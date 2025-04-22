db = db.getSiblingDB('arso-reservas')

db.createCollection('eventos')

db.eventos.insertMany([
  {
    _id: 'a1b0c40d-9c2f-4c3a-b2f5-5fa67eeb3758',
    plazasDisponibles: 25,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'c9d49d01-df52-48ac-bc5f-0f890328e49f'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'f5570b1f-4bfc-4f67-93e9-12140a0b7e12',
    plazasDisponibles: 40,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'bcb71134-7d2b-44d4-a029-b99d086ee30b'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '3de79bb2-1995-426e-8a7a-4307f1b84027',
    plazasDisponibles: 50,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'b7c319d9-4102-4509-a7a7-d38f6b855aa6',
    plazasDisponibles: 37,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'f6729f32-4c6c-4b3d-b925-9a3b8fe4d8b3'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '9d31509b-bd62-41c2-bb2f-084504b0177e',
    plazasDisponibles: 35,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: '72819e5f-1cc1-4789-b9b4-8e1d08a30161'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '951dfd5b-6047-4f7e-bba9-3be6d03425ac',
    plazasDisponibles: 30,
    cancelado: false,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'd0d7f883-e7c0-4fe1-94e4-e9ca16776e7e',
    plazasDisponibles: 92,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: '2bb64a4c-7773-4f6c-85a3-f9ed6d05c9b5'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'fa21365f-8f89-4bfe-b91f-d00320f76e6e',
    plazasDisponibles: 15,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'fa3f2b44-f44d-40ba-9d65-f90a8e15321f'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '1f3a0a04-5a99-4744-9e7e-4351b8fcd210',
    plazasDisponibles: 97,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: '70a1a94e-8b52-4313-bd73-fc5e303ab512'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'cb1d407b-18e0-4b62-9a64-cfcb1ffebdb2',
    plazasDisponibles: 35,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'ac40d4ea-dc2d-4779-91f7-78efbf5828f1'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'cf78a67b-e607-41a7-b9f0-c0fe64329c4a',
    plazasDisponibles: 20,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: '5446349b-2ab5-4b6b-9090-3706d710c833'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '0174cc84-99d1-46ac-a2c4-278f16317c0e',
    plazasDisponibles: 60,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'bc85b58f-cc4c-4f8b-b8ec-eef88a787a45'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '1a337705-6d13-4672-bfbd-bf65a3e4e1ca',
    plazasDisponibles: 45,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'a839ad58-b7f1-4c2d-bc1c-41f0ebad5ef2'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'b3479c34-808e-4674-957d-09a7204285e5',
    plazasDisponibles: 95,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'a4a59ea6-c301-47e0-9d9e-977340b71b72'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'a2d2ea4d-b1f9-4b91-86cc-e1448f16c4e4',
    plazasDisponibles: 57,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'f081bb24-bd9e-46f7-9e42-b9b7e7d7b595'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '6c8ea2cd-c85f-4ed0-a874-d4f01738c8fe',
    plazasDisponibles: 60,
    cancelado: false,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'c0d6c3de-9c3f-4d16-bdc1-d7c57438909e',
    plazasDisponibles: 80,
    cancelado: false,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '7d5cd836-e399-43b4-b924-c0241d0608ff',
    plazasDisponibles: 100,
    cancelado: false,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '742c5167-720d-4b3d-9296-5429e6fbb6b2',
    plazasDisponibles: 70,
    cancelado: false,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'ec26c385-28cf-40f0-b8ea-c609c4b4dbfd',
    plazasDisponibles: 100,
    cancelado: false,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '45f11c0e-5502-4d55-bfe9-0ac2d59d2803',
    plazasDisponibles: 100,
    cancelado: false,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '3c64ff92-b4e3-4a3b-9e22-2a0e8d9a137b',
    plazasDisponibles: 70,
    cancelado: false,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'ba99b3e9-c24e-44cc-91c9-846d07c5bff5',
    plazasDisponibles: 100,
    cancelado: false,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '517e65ea-7c7e-40ad-b9b5-b34271e21388',
    plazasDisponibles: 200,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'a21a40c7-9f82-44f7-b2d3-e9abca7253f0',
    plazasDisponibles: 50,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '462feb5e-d0a2-459a-ae9e-b72289ed774f',
    plazasDisponibles: 50,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'e2cdd4ac-d6f8-4e74-9b79-c5f7133027a3',
    plazasDisponibles: 90,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'edabf476-c6a0-46fd-b5e6-322568fd1265',
    plazasDisponibles: 40,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: '337d2145-e8d9-4012-83f2-50128907294d',
    plazasDisponibles: 40,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },

  {
    _id: 'a1e11111-aaaa-1aaa-1aaa-bbbbbbbb0001',
    plazasDisponibles: 98,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'aaa1aaa1-aaaa-4aaa-aaaa-aaaaaaaa0001'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'c3e33333-cccc-3ccc-3ccc-dddddddd0003',
    plazasDisponibles: 78,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'bbb2bbb2-bbbb-5bbb-bbbb-bbbbbbbb0002'
      },
      {
        $ref: 'reservas',
        $id: 'bbb2bbb2-bbbb-4bbb-bbbb-bbbbbbbb0002'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'e5e55555-eeee-5eee-5eee-ffffeeee0005',
    plazasDisponibles: 37,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'ccc3ccc3-cccc-4ccc-cccc-cccccccc0003'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'g7e77777-gggg-7ggg-7ggg-hhhhhhhh0007',
    plazasDisponibles: 83,
    cancelado: false,
    reservas: [
      {
        $ref: 'reservas',
        $id: 'ddd4ddd4-dddd-4ddd-dddd-dddddddd0004'
      },
      {
        $ref: 'reservas',
        $id: 'fff6fff6-ffff-4fff-ffff-ffffffff0006'
      },
      {
        $ref: 'reservas',
        $id: 'eee5eee5-eeee-4eee-eeee-eeeeeeee0005'
      }
    ],
    _class: 'reservas.modelo.Evento'
  },

  {
    _id: 'h8e88888-hhhh-1hhh-5hhh-iiiiiiii0008',
    plazasDisponibles: 30,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'i9e99999-iiii-2iii-6iii-jjjjjjjj0009',
    plazasDisponibles: 16,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'j0e00000-jjjj-3jjj-7jjj-kkkkkkkk0010',
    plazasDisponibles: 60,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  },
  {
    _id: 'k1e11112-kkkk-4kkk-8kkk-llllllll0011',
    plazasDisponibles: 50,
    cancelado: true,
    reservas: [],
    _class: 'reservas.modelo.Evento'
  }
])

db.createCollection('reservas')

db.reservas.insertMany([
  {
    _id: 'c9d49d01-df52-48ac-bc5f-0f890328e49f',
    idUsuario: 'e6896a1e-49b6-4b56-91d7-03e7f6b2c925',
    plazasReservadas: 5,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'a1b0c40d-9c2f-4c3a-b2f5-5fa67eeb3758' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'bcb71134-7d2b-44d4-a029-b99d086ee30b',
    idUsuario: 'd3abf032-06f1-4f0c-9490-bd4d5287d1f3',
    plazasReservadas: 10,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'f5570b1f-4bfc-4f67-93e9-12140a0b7e12' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'f6729f32-4c6c-4b3d-b925-9a3b8fe4d8b3',
    idUsuario: 'afa9f62e-6a9f-4fe6-96e6-cf02d1342399',
    plazasReservadas: 3,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'b7c319d9-4102-4509-a7a7-d38f6b855aa6' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: '72819e5f-1cc1-4789-b9b4-8e1d08a30161',
    idUsuario: 'ff6358be-5397-417a-b1a1-d58f5d835983',
    plazasReservadas: 15,
    cancelada: false,
    evento: { $ref: 'eventos', $id: '9d31509b-bd62-41c2-bb2f-084504b0177e' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: '2bb64a4c-7773-4f6c-85a3-f9ed6d05c9b5',
    idUsuario: '2d7b2a38-72ad-4e99-bd76-b1e3cb6b9e3c',
    plazasReservadas: 8,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'd0d7f883-e7c0-4fe1-94e4-e9ca16776e7e' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'fa3f2b44-f44d-40ba-9d65-f90a8e15321f',
    idUsuario: 'd5b8d9c5-7384-45ab-b95b-8159a8ac2d3e',
    plazasReservadas: 20,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'fa21365f-8f89-4bfe-b91f-d00320f76e6e' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: '70a1a94e-8b52-4313-bd73-fc5e303ab512',
    idUsuario: '4db1cfc3-38e4-45b1-a0cf-80b91b7d5c76',
    plazasReservadas: 3,
    cancelada: false,
    evento: { $ref: 'eventos', $id: '1f3a0a04-5a99-4744-9e7e-4351b8fcd210' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'ac40d4ea-dc2d-4779-91f7-78efbf5828f1',
    idUsuario: '33b33028-87d1-4d6a-b61f-086a249c8571',
    plazasReservadas: 10,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'cb1d407b-18e0-4b62-9a64-cfcb1ffebdb2' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: '5446349b-2ab5-4b6b-9090-3706d710c833',
    idUsuario: '46bb0f92-2e74-4fa6-9f8f-c8b0717f8504',
    plazasReservadas: 5,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'cf78a67b-e607-41a7-b9f0-c0fe64329c4a' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'bc85b58f-cc4c-4f8b-b8ec-eef88a787a45',
    idUsuario: 'de5648ff-0547-4766-bf37-f92a1abf06a9',
    plazasReservadas: 10,
    cancelada: false,
    evento: { $ref: 'eventos', $id: '0174cc84-99d1-46ac-a2c4-278f16317c0e' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'a839ad58-b7f1-4c2d-bc1c-41f0ebad5ef2',
    idUsuario: 'e2901065-724e-4b8a-a5f7-d34664c8f885',
    plazasReservadas: 15,
    cancelada: false,
    evento: { $ref: 'eventos', $id: '1a337705-6d13-4672-bfbd-bf65a3e4e1ca' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'a4a59ea6-c301-47e0-9d9e-977340b71b72',
    idUsuario: 'd9b8ff1e-5082-4fa3-b078-dafedb4f177d',
    plazasReservadas: 5,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'b3479c34-808e-4674-957d-09a7204285e5' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'f081bb24-bd9e-46f7-9e42-b9b7e7d7b595',
    idUsuario: 'a4d3e33b-f473-46d8-a992-e968ff481b40',
    plazasReservadas: 3,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'a2d2ea4d-b1f9-4b91-86cc-e1448f16c4e4' },
    _class: 'reservas.modelo.Reserva'
  },

  {
    _id: 'aaa1aaa1-aaaa-4aaa-aaaa-aaaaaaaa0001',
    idUsuario: 'd9428888-122b-4cbb-bcb9-33a3ee6b9e9b',
    plazasReservadas: 2,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'a1e11111-aaaa-1aaa-1aaa-bbbbbbbb0001' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'bbb2bbb2-bbbb-5bbb-bbbb-bbbbbbbb0002',
    idUsuario: 'd9428888-122b-4cbb-bcb9-33a3ee6b9e9b',
    plazasReservadas: 1,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'c3e33333-cccc-3ccc-3ccc-dddddddd0003' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'ddd4ddd4-dddd-4ddd-dddd-dddddddd0004',
    idUsuario: 'd9428888-122b-4cbb-bcb9-33a3ee6b9e9b',
    plazasReservadas: 4,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'g7e77777-gggg-7ggg-7ggg-hhhhhhhh0007' },
    _class: 'reservas.modelo.Reserva'
  },

  {
    _id: 'bbb2bbb2-bbbb-4bbb-bbbb-bbbbbbbb0002',
    idUsuario: '5f3d9d2a-63cc-4d3a-8c45-d56d7dbad2e3',
    plazasReservadas: 1,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'c3e33333-cccc-3ccc-3ccc-dddddddd0003' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'eee5eee5-eeee-4eee-eeee-eeeeeeee0005',
    idUsuario: '5f3d9d2a-63cc-4d3a-8c45-d56d7dbad2e3',
    plazasReservadas: 2,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'g7e77777-gggg-7ggg-7ggg-hhhhhhhh0007' },
    _class: 'reservas.modelo.Reserva'
  },

  {
    _id: 'ccc3ccc3-cccc-4ccc-cccc-cccccccc0003',
    idUsuario: '6b1d3d79-a0e5-41c9-bb5e-9b90e9b0c5e1',
    plazasReservadas: 3,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'e5e55555-eeee-5eee-5eee-ffffeeee0005' },
    _class: 'reservas.modelo.Reserva'
  },
  {
    _id: 'fff6fff6-ffff-4fff-ffff-ffffffff0006',
    idUsuario: '6b1d3d79-a0e5-41c9-bb5e-9b90e9b0c5e1',
    plazasReservadas: 1,
    cancelada: false,
    evento: { $ref: 'eventos', $id: 'g7e77777-gggg-7ggg-7ggg-hhhhhhhh0007' },
    _class: 'reservas.modelo.Reserva'
  }
])
