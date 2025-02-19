package espacios.rest;

import java.net.URI;

import java.util.stream.Collectors;

import java.time.LocalDateTime;
import java.util.List;
import java.util.LinkedList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PATCH;
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
import espacios.servicio.FactoriaServicios;
import espacios.servicio.IServicioEspacios;
import espacios.rest.dto.CreateEspacioFisicoDTO;
import espacios.rest.dto.Listado;
import espacios.rest.dto.PuntoInteresDTO;
import espacios.rest.dto.UpdateEspacioFisicoDTO;
import espacios.rest.dto.Listado.ResumenExtendido;
import espacios.rest.mapper.EspacioFisicoMapper;
import espacios.rest.mapper.PuntoInteresMapper;

@Path("espaciosfisicos")
public class ControladorEspacios {

    private IServicioEspacios servicio = FactoriaServicios.getServicio(IServicioEspacios.class);

    @Context
    private UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEspacio(CreateEspacioFisicoDTO espacioFisicoDTO) throws Exception {

        EspacioFisico espacioFisico = EspacioFisicoMapper.toEntity(espacioFisicoDTO);
        String id = servicio.altaEspacioFisico(espacioFisico.getNombre(), espacioFisico.getPropietario(),
                espacioFisico.getCapacidad(), espacioFisico.getDireccion(), espacioFisico.getLatitud(),
                espacioFisico.getLongitud(),
                espacioFisico.getDescripcion());

        URI nuevaURL = this.uriInfo.getAbsolutePathBuilder().path(id).build();
        return Response.created(nuevaURL).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEspacio(@PathParam("id") String idEspacioFisico) throws Exception {
        EspacioFisico espacioFisico = servicio.recuperarEspacioFisico(idEspacioFisico);
        return Response.status(Response.Status.OK).entity(EspacioFisicoMapper.toDTO(espacioFisico)).build();
    }

    @PATCH
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEspacio(@PathParam("id") String id, UpdateEspacioFisicoDTO espacioFisicoDTO)
            throws Exception {
        EspacioFisico espacioFisico = EspacioFisicoMapper.toEntity(espacioFisicoDTO);

        servicio.modificarEspacioFisico(id, espacioFisico.getNombre(), espacioFisico.getCapacidad(),
                espacioFisico.getDescripcion());

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{id}/estado")
    public Response cambiarEstadoEspacio(@PathParam("id") String id, @FormParam("estado") String estado)
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarEspaciosFisicosLibres(@QueryParam("fechainicio") String fechaInicio,
            @QueryParam("fechafin") String fechaFin, @QueryParam("capacidad") int capacidad) throws Exception {

        System.out.println(fechaInicio + " " + fechaFin + " " + capacidad);
        List<EspacioFisico> espaciosFisicosLibres = servicio.buscarEspaciosFisicosLibres(
                LocalDateTime.parse(fechaInicio),
                LocalDateTime.parse(fechaFin), capacidad);

        LinkedList<ResumenExtendido> extendido = new LinkedList<>();

        for (EspacioFisico espacioFisico : espaciosFisicosLibres) {
            ResumenExtendido resumenExtendido = new ResumenExtendido();
            resumenExtendido.setEspacioDTO(EspacioFisicoMapper.toResumenDTO(espacioFisico));

            String id = espacioFisico.getId();
            URI nuevaURL = this.uriInfo.getBaseUriBuilder().path(getClass()).path(id).build();
            resumenExtendido.setUrl(nuevaURL.toString());

            extendido.add(resumenExtendido);
        }

        Listado listado = new Listado();
        listado.setEspacio(extendido);
        return Response.ok(listado).build();
    }

    @PUT
    @Path("/{id}/puntosinteres")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response asignarPuntosDeInteres(@PathParam("id") String id, List<PuntoInteresDTO> puntosInteresDTO)
            throws Exception {

        LinkedList<PuntoInteres> puntosInteres = new LinkedList<>(
                puntosInteresDTO.stream().map(p -> PuntoInteresMapper.fromDTO(p)).collect(Collectors.toList()));

        servicio.asignarPuntosDeInteres(id, puntosInteres);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}