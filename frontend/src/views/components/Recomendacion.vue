<template>
  <card gradient="secondary" shadow body-classes="p-lg-5">
    <base-alert type="warning" v-if="recomendaciones.length == 0">
      <span class="alert-inner--icon">
        <i class="ni ni-bulb-61"></i>
      </span>
      <span class="alert-inner--text">No se encontraron universidades para recomendar :(</span>
    </base-alert>
    <h4
      v-else
      style="font-weight: bold;"
      class="mb-1 text-center"
    >Estas son las universidades que te recomendamos según tus preferencias!</h4>
    <br>

    <badger-accordion :options="{openMultiplePanels: true}">
      <badger-accordion-item
        v-for="(recomendacion, index) in ranking"
        v-bind:key="recomendacion.id"
      >
        <template slot="header">
          <h5 style="font-weight: bold;">{{index+1}}.- {{ recomendacion.name }}</h5>
        </template>
        <template slot="content">
          <card>
            <div class="row">
              <div class="col-3">
                <img
                  alt="Rounded image"
                  class="img-fluid rounded shadow"
                  :src="recomendacion.urlEscudo"
                  lazy="loaded"
                  style="width: 150px;"
                >
              </div>
              <div class="col-9">
                <h4>
                  <strong>{{ recomendacion.name }}</strong>
                </h4>
                <strong>Tipo de institución:</strong>
                {{ recomendacion.isPrivate == 0 ? 'Pública' : 'Privada'}}
                <br>
                <strong>Ubicación:</strong>
                Región {{ obtenerNombreRegion(recomendacion.region) }}
                <a
                  target="_blank"
                  :href="'http://maps.google.com/maps?z=12&t=m&q=loc:'+recomendacion.lat+'+'+recomendacion.lng"
                >(Ver en google maps)</a>
                <br>
                <strong>Página web:</strong>
                <a target="_blank" :href="recomendacion.url"> {{ recomendacion.url }}</a>
                <br>
                <strong>Ranking Universitas 2018:</strong> {{ recomendacion.rankUniver }}
                <br>
                <strong>Años de Acreditación:</strong> {{ recomendacion.anosAcr}}
                <br>
                <br>
                <h5>
                  <strong>Puntos obtenidos según tus preferencias</strong>
                </h5>
                <strong>Ranking:</strong>
                {{ recomendacion.pointsWithNear[2] }}
                <br>
                <strong>Años de Acreditación:</strong>
                {{ recomendacion.pointsWithNear[1] }}
                <br>
                <strong>Becas:</strong>
                {{ recomendacion.pointsWithNear[0] }}
                <br>
                <strong>Cercanía:</strong>
                {{ recomendacion.pointsWithNear[3] }}
                <br>
                <strong>Distancia entre tu ubicación y la universidad:</strong>
                {{ parseFloat(recomendacion.distanceLatLng/1000).toFixed(2) }}km
                <br>
                <br>
                <badger-accordion :options="{openHeadersOnLoad: [0]}">
                  <badger-accordion-item>
                    <template slot="header">
                      <h6 style="font-weight: bold;">Ver carreras</h6>
                    </template>
                    <template slot="content">
                      <ul id="">
                        <li v-for="carrera in recomendacion.careers" v-bind:key="carrera.id">{{ carrera.name }}</li>
                      </ul>
                    </template>
                  </badger-accordion-item>
                </badger-accordion>
              </div>
            </div>
          </card>
        </template>
      </badger-accordion-item>
    </badger-accordion>
  </card>
</template>

<script>
import { BadgerAccordion, BadgerAccordionItem } from "vue-badger-accordion";

export default {
  name: "recomendacion",
  components: {
    BadgerAccordion,
    BadgerAccordionItem
  },
  props: {
    recomendaciones: {
      default: [],
      type: Array
    }
  },
  beforeMount() {
    var app = this;
    this.recomendaciones.forEach(function callback(
      recomendacion,
      i,
      recomendaciones
    ) {
      if (i < 3) app.ranking.push(recomendacion);
    });
  },
  data() {
    return {
      ranking: []
    };
  },
  methods: {
    obtenerNombreRegion(nRegion) {
      switch (nRegion) {
        case 0:
          return "Metropolitana";
        case 1:
          return "de Tarapacá";
        case 2:
          return "de Antofagasta";
        case 3:
          return "de Atacama";
        case 4:
          return "de Coquimbo";
        case 5:
          return "de Valparaíso";
        case 6:
          return "del Libertador Gral. Bernardo O'Higgins";
        case 7:
          return "del Maule";
        case 8:
          return "del Bío Bío";
        case 9:
          return "del la Araucanía";
        case 10:
          return "de los Lagos";
        case 11:
          return "de Aysén del Gral. Ibáñez del Campo";
        case 12:
          return "de Magallanes y de la Antártica Chilena";
        case 13:
          return "---";
        case 14:
          return "de los Rios";
      }
    }
  }
};
</script>