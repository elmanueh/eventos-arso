package espacios.rest;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import espacios.modelo.EspacioFisico;
import espacios.modelo.EspacioFisicoEstado;
import espacios.modelo.PuntoInteres;
import espacios.rest.dto.CreateEspacioFisicoDTO;
import espacios.rest.dto.Listado;
import espacios.rest.dto.Listado.ResumenExtendido;
import espacios.rest.dto.PuntoInteresDTO;
import espacios.rest.dto.UpdateEspacioFisicoDTO;
import espacios.rest.mapper.EspacioFisicoMapper;
import espacios.rest.mapper.PuntoInteresMapper;
import espacios.servicio.IServicioEspacios;
import espacios.servicio.core.FactoriaServicios;

@Path("espaciosfisicos")
public class ControladorEspacios {

    private final IServicioEspacios servicio = FactoriaServicios.getServicio(IServicioEspacios.class);

    @Context
    private UriInfo uriInfo;

    @POST
    @RolesAllowed("PROPIETARIO_ESPACIOS")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEspacio(CreateEspacioFisicoDTO espacioFisicoDTO) throws Exception {

        EspacioFisico espacioFisico = EspacioFisicoMapper.toEntity(espacioFisicoDTO);
        UUID id = servicio.altaEspacioFisico(espacioFisico.getNombre(), espacioFisico.getPropietario(),
                espacioFisico.getCapacidad(), espacioFisico.getDireccion(), espacioFisico.getLatitud(),
                espacioFisico.getLongitud(),
                espacioFisico.getDescripcion());

        URI nuevaURL = this.uriInfo.getAbsolutePathBuilder().path(id.toString()).build();
        return Response.created(nuevaURL).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "PROPIETARIO_ESPACIOS", "USUARIO" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEspacio(@PathParam("id") UUID idEspacioFisico) throws Exception {
        EspacioFisico espacioFisico = servicio.recuperarEspacioFisico(idEspacioFisico);
        return Response.status(Response.Status.OK).entity(EspacioFisicoMapper.toDTO(espacioFisico)).build();
    }

    @PATCH
    @Path("/{id}")
    @RolesAllowed("PROPIETARIO_ESPACIOS")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEspacio(@PathParam("id") UUID id, UpdateEspacioFisicoDTO espacioFisicoDTO)
            throws Exception {
        EspacioFisico espacioFisico = EspacioFisicoMapper.toEntity(espacioFisicoDTO);

        servicio.modificarEspacioFisico(id, espacioFisico.getNombre(), espacioFisico.getCapacidad(),
                espacioFisico.getDescripcion());

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{id}/estado")
    @RolesAllowed("PROPIETARIO_ESPACIOS")
    public Response cambiarEstadoEspacio(@PathParam("id") UUID id, @FormParam("estado") String estado)
            throws Exception {

        EspacioFisicoEstado estadoEnum;
        try {
            estadoEnum = EspacioFisicoEstado.valueOf(estado);
        } catch (Exception e) {
            throw new IllegalArgumentException("El estado con valor " + estado + " no es válido");
        }

        if (estadoEnum.equals(EspacioFisicoEstado.ACTIVO))
            servicio.activarEspacioFisico(id);
        else
            servicio.bajaEspacioFisico(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/libre")
    @RolesAllowed({ "PROPIETARIO_ESPACIOS", "USUARIO" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarEspaciosFisicosLibres(@QueryParam("fechainicio") String fechaInicio,
            @QueryParam("fechafin") String fechaFin, @QueryParam("capacidad") int capacidad) throws Exception {

        List<EspacioFisico> espaciosFisicosLibres = servicio.buscarEspaciosFisicosLibres(
                LocalDateTime.parse(fechaInicio),
                LocalDateTime.parse(fechaFin), capacidad);

        LinkedList<ResumenExtendido> extendido = new LinkedList<>();

        for (EspacioFisico espacioFisico : espaciosFisicosLibres) {
            ResumenExtendido resumenExtendido = new ResumenExtendido();
            resumenExtendido.setEspacioDTO(EspacioFisicoMapper.toResumenDTO(espacioFisico));

            UUID id = espacioFisico.getId();
            URI nuevaURL = this.uriInfo.getBaseUriBuilder().path(getClass()).path(id.toString()).build();
            resumenExtendido.setUrl(nuevaURL.toString());

            extendido.add(resumenExtendido);
        }

        Listado listado = new Listado();
        listado.setEspacio(extendido);
        return Response.ok(listado).build();
    }

    @PUT
    @Path("/{id}/puntosinteres")
    @RolesAllowed("PROPIETARIO_ESPACIOS")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response asignarPuntosDeInteres(@PathParam("id") UUID id, List<PuntoInteresDTO> puntosInteresDTO)
            throws Exception {

        LinkedList<PuntoInteres> puntosInteres = new LinkedList<>(
                puntosInteresDTO.stream().map(p -> PuntoInteresMapper.fromDTO(p)).collect(Collectors.toList()));

        servicio.asignarPuntosDeInteres(id, puntosInteres);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/propietario/{propietario}")
    @RolesAllowed({ "PROPIETARIO_ESPACIOS" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEspaciosPorPropietario(@PathParam("propietario") String propietario) throws Exception {
        List<EspacioFisico> espacios = servicio.recuperarEspaciosPorPropietario(propietario);

        LinkedList<ResumenExtendido> extendido = new LinkedList<>();

        for (EspacioFisico espacioFisico : espacios) {
            ResumenExtendido resumenExtendido = new ResumenExtendido();
            resumenExtendido.setEspacioDTO(EspacioFisicoMapper.toResumenDTO(espacioFisico));

            UUID id = espacioFisico.getId();
            URI nuevaURL = this.uriInfo.getBaseUriBuilder().path(getClass()).path(id.toString()).build();
            resumenExtendido.setUrl(nuevaURL.toString());

            extendido.add(resumenExtendido);
        }

        Listado listado = new Listado();
        listado.setEspacio(extendido);
        return Response.ok(listado).build();
    }

    @GET
    @RolesAllowed({ "PROPIETARIO_ESPACIOS", "USUARIO" })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEspaciosFisicos() throws Exception {
        List<EspacioFisico> espacios = servicio.recuperarTodosLosEspacios();

        LinkedList<ResumenExtendido> extendido = new LinkedList<>();

        for (EspacioFisico espacioFisico : espacios) {
            ResumenExtendido resumenExtendido = new ResumenExtendido();
            resumenExtendido.setEspacioDTO(EspacioFisicoMapper.toResumenDTO(espacioFisico));

            UUID id = espacioFisico.getId();
            URI nuevaURL = this.uriInfo.getBaseUriBuilder().path(getClass()).path(id.toString()).build();
            resumenExtendido.setUrl(nuevaURL.toString());

            extendido.add(resumenExtendido);
        }

        Listado listado = new Listado();
        listado.setEspacio(extendido);
        return Response.ok(listado).build();
    }

}