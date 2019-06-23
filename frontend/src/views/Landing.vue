<template>
  <div>
    <div class="position-relative">
      <!-- shape Hero -->
      <section class="section-shaped my-0">
        <div class="shape shape-style-1 shape-default shape-skew">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          <span></span>
        </div>
        <div class="container shape-container d-flex">
          <div class="col px-0">
            <div class="row">
              <div class="col-lg-8">
                <h1 class="display-3 text-white">
                  Busca tu futura alma mater!
                  <span>gracias a nuestro recomendador online</span>
                </h1>
                <p class="lead text-white">
                  Este proyecto, te recomienda una universidad en base a
                  una encuesta que debes realizar.
                </p>
                <div class="btn-wrapper">
                  <base-button
                    class="mb-3 mb-sm-0"
                    type="warning"
                    icon="fa fa-question"
                    v-scroll-to="'#how'"
                  >¿Como funciona?</base-button>
                  <base-button
                    class="mb-3 mb-sm-0"
                    type="white"
                    icon="fa fa-check-square"
                    v-scroll-to="'#start'"
                  >Comenzar</base-button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>

    <section class="section section-lg pt-lg-0" id="how">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-12">
            <div class="row row-grid">
              <div class="col-lg-4">
                <card class="border-0" hover shadow body-classes="py-5">
                  <icon name="ni ni-hat-3" type="default" rounded class="mb-4"></icon>
                  <h6 class="text-default text-uppercase">Universidades y Carreras involucradas</h6>
                  <p class="description mt-3">
                    Los datos reunidos corresponden a las universidades pertenecientes al CRUCH y las carreras
                    que se toman en cuenta son las mas elegidas por los estudiantes chilenos según la prensa nacional.
                  </p>
                  <base-button
                    block
                    type="default"
                    class="mb-2"
                    @click="modals.universidades = true"
                  >Ver Universidades</base-button>
                  <base-button
                    block
                    type="default"
                    class="mb-2"
                    @click="modals.carreras = true"
                  >Ver Carreras</base-button>
                </card>
              </div>
              <div class="col-lg-4">
                <card class="border-0" hover shadow body-classes="py-5">
                  <icon name="ni ni-check-bold" type="primary" rounded class="mb-4"></icon>
                  <h6 class="text-primary text-uppercase">Eleccion de caracteristicas</h6>
                  <p class="description mt-3">
                    Se realizó un cuestionario web para determinar las 5 caracteristicas mas relevantes
                    a la hora de elegir una universidad.
                  </p>
                  <base-button
                    tag="a"
                    target="_blank"
                    href="https://forms.gle/5uVYB6NYRUVdRjSo6"
                    type="primary"
                    class="mt-4"
                  >Acceso a la Encuesta</base-button>
                </card>
              </div>
              <div class="col-lg-4">
                <card class="border-0" hover shadow body-classes="py-5">
                  <icon name="ni ni-sound-wave" type="success" rounded class="mb-4"></icon>
                  <h6 class="text-success text-uppercase">Recoleccion y manejo de datos</h6>
                  <p class="description mt-3">
                    Proceso en el cual se recolectaron todos los datos relacionados a las 5 caracteristicas mas relevantes
                    para luego determinar los distintos puntajes en cada item por universidad.
                  </p>
                  <base-button
                    tag="a"
                    target="_blank"
                    href="https://docs.google.com/spreadsheets/d/1KdvloNuEjrxjkIjWlu97vWzn6tJ7HPOOQQvcF_ZdZMU/edit#gid=1775782665"
                    type="success"
                    class="mt-4"
                  >Ver recoleccion y manejo</base-button>
                </card>
              </div>
              <div class="row text-center justify-content-center">
                <div class="col-lg-6">
                  <card class="border-0" hover shadow body-classes="py-5">
                    <icon name="ni ni-planet" type="warning" rounded class="mb-5"></icon>
                    <h6 class="text-warning text-uppercase">Desarrollo de Algoritmo recomendador</h6>
                    <p class="description mt-3">
                      Finalmente, se implementa un algoritmo recomendador basado en semejanza.Se basa principalmente en
                      comparar su resultado de la encuesta versus el puntaje de cada item de las universidades en este proyecto,
                      y asi mostrar las mas adecuadas.
                    </p>
                    <base-button
                      tag="a"
                      target="_blank"
                      href="https://github.com/JorgeSilva7/Alma-mater"
                      type="warning"
                      class="mt-4"
                    >Ver Codigo Fuente</base-button>
                  </card>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <modal :show.sync="modals.universidades">
      <h6 slot="header" class="modal-title" id="modal-title-default">Listado de Universidades</h6>
      <!-- <ul id>
        <li v-for="universidad in universidades" v-bind:key="universidad.id">{{ universidad.name }}</li>
      </ul>-->
      <badger-accordion :options="{openMultiplePanels: true}">
        <badger-accordion-item
          v-for="(universidad, index) in universidades"
          v-bind:key="universidad.id"
        >
          <template slot="header">
            <h6 style="font-weight: bold;">{{index+1}}.- {{ universidad.name }}</h6>
          </template>
          <template slot="content">
            <card>
              <div class="row">
                <div class="col-3">
                  <img
                    alt="Rounded image"
                    class="img-fluid rounded shadow"
                    :src="universidad.urlEscudo"
                    lazy="loaded"
                    style="width: 150px;"
                  >
                </div>
                <div class="col-9">
                  <h4>
                    <strong>{{ universidad.name }}</strong>
                  </h4>
                  <strong>Tipo de institución:</strong>
                  {{ universidad.isPrivate == 0 ? 'Pública' : 'Privada'}}
                  <br>
                  <strong>Ubicación:</strong>
                  Región {{ utils.obtenerNombreRegion(universidad.region) }}
                  <a
                    target="_blank"
                    :href="'http://maps.google.com/maps?z=12&t=m&q=loc:'+universidad.lat+'+'+universidad.lng"
                  >(Ver en google maps)</a>
                  <br>
                  <strong>Página web:</strong>
                  <a target="_blank" :href="universidad.url">{{ universidad.url }}</a>
                  <br>
                  <strong>Ranking Universitas 2018:</strong>
                  {{ universidad.rankUniver }}
                  <br>
                  <strong>Años de Acreditación:</strong>
                  {{ universidad.anosAcr}}
                  <br>
                </div>
              </div>
            </card>
          </template>
        </badger-accordion-item>
      </badger-accordion>
      <template slot="footer">
        <base-button type="link" class="ml-auto" @click="modals.universidades = false">Cerrar</base-button>
      </template>
    </modal>

    <modal :show.sync="modals.carreras">
      <h6 slot="header" class="modal-title" id="modal-title-default">Listado de Carreras</h6>
      <ul id>
        <li v-for="carrera in carreras" v-bind:key="carrera.id">{{ carrera.name }}</li>
      </ul>
     <template slot="footer">
        <base-button type="link" class="ml-auto" @click="modals.carreras = false">Cerrar</base-button>
      </template>
    </modal>

    <section class="section section-shaped my-0 overflow-hidden">
      <div class="shape shape-style-3 bg-gradient-default shape-skew">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
      </div>
      <div class="container pt-lg pb-300" id="start">
        <div class="row text-center justify-content-center">
          <div class="col-lg-10">
            <h2 class="display-3 text-white">Busca Alma Mater</h2>
            <p
              class="lead text-white"
            >Para recomendarte una universidad, es necesario que leas con cuidado la explicacion de cada caracteristica que se te preguntará.</p>
          </div>
        </div>
        <div class="row row-grid mt-5 text-center justify-content-center">
          <div class="col-lg-3">
            <icon name="fa fa-list-ol" size="lg" gradient="white" shadow round color="primary"></icon>
            <h5 class="text-white mt-3">Ranking</h5>
            <p class="text-white mt-3">
              El ranking de universidades seleccionado fue el de Universitas y "El Mercurio" 2018. Este ranking tiene como objetivo
              Informar a quienes desean realizar estudios universitarios sobre los perfiles académicos y el
              desempeño de las universidades chilenas y la calidad de algunos de sus programas de estudio
              .
            </p>
          </div>
          <div class="col-lg-3">
            <icon name="fa fa-money" size="lg" gradient="white" shadow round color="primary"></icon>
            <h5 class="text-white mt-3">Becas</h5>
            <p class="text-white mt-3">
              Estas becas son las distintas ayudas económicas para solventar cualquier gasto universitario, ya sea arancel de carrera, salud,
              locomoción, titulación, etc.
            </p>
          </div>
          <div class="col-lg-3">
            <icon name="fa fa-shield" size="lg" gradient="white" shadow round color="primary"></icon>
            <h5 class="text-white mt-3">Años de acreditación</h5>
            <p class="text-white mt-3">
              La acreditación es la certificación pública que entrega un organismo externo
              (Comisión Nacional de Acreditación o una Agencia de Acreditación) sobre la calidad de la educación que imparte la Universidad.
              En este proyecto, se utiliza la acreditación institucional.
            </p>
          </div>
          <div class="col-lg-3">
            <icon name="fa fa-map-marker" size="lg" gradient="white" shadow round color="primary"></icon>
            <h5 class="text-white mt-3">Cercanía</h5>
            <p class="text-white mt-3">
              Es importante que entreges correctamente esta informacíon, ya que la puntuación de esta caracteristica se
              calculará a partir de la entrega de tu posición. Puedes permitir obtener tu ubicación o indicarla manualmente.
            </p>
          </div>
        </div>
        <div class="row row-grid mt-5 text-center justify-content-center">
          <div class="col-lg-4">
            <icon name="fa fa-university" size="lg" gradient="white" shadow round color="primary"></icon>
            <h5 class="text-white mt-3">Carrera(s) de Interes*</h5>
            <p
              class="text-white mt-3"
            >Te entregamos la posibilidad de elegir hasta 3 carreras de interés y asi aplicar el algoritmo solo a las universidades con esas carreras. (OPCIONAL)</p>
          </div>
        </div>
      </div>
    </section>
    <section class="section section-lg pt-lg-0">
      <div class="container">
        <div class="row justify-content-center mt--300">
          <div class="col-lg-12">
            <card gradient="secondary" shadow body-classes="p-lg-5" id="form-card">
              <base-alert type="danger" v-show="error">
                <span class="alert-inner--icon">
                  <i class="ni ni-bell-55"></i>
                </span>
                <span class="alert-inner--text">Hay errores en tu formulario! Revisalo</span>
              </base-alert>
              <h4
                style="font-weight: bold;"
                class="mb-1"
              >Responde esta encuesta para que te podamos recomendar!</h4>
              <base-input
                class="mt-3"
                alternative
                placeholder="Tu nombre (opcional)"
                addon-left-icon="ni ni-badge"
                require
                v-model="name"
              ></base-input>
              <br>
              <h5
                class="mt-0"
              >Selecciona el nivel de importancia del 1 al 5 (Donde 1 es irrelevante y 5 es muy importante).</h5>
              <br>
              <br>
              <h5 style="font-weight: bold;" :class="{'text-danger': rnkError}">Ranking Nacional*</h5>
              <div class="row">
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="rankingNacional"
                      class="custom-control-input"
                      id="rankingNacional1"
                      type="radio"
                      value="1"
                      v-model="rankingNacional"
                      v-on:click="rnkError = false"
                    >
                    <label class="custom-control-label" for="rankingNacional1">1</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="rankingNacional"
                      class="custom-control-input"
                      id="rankingNacional2"
                      type="radio"
                      value="2"
                      v-model="rankingNacional"
                      v-on:click="rnkError = false"
                    >
                    <label class="custom-control-label" for="rankingNacional2">2</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="rankingNacional"
                      class="custom-control-input"
                      id="rankingNacional3"
                      type="radio"
                      value="3"
                      v-model="rankingNacional"
                      v-on:click="rnkError = false"
                    >
                    <label class="custom-control-label" for="rankingNacional3">3</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="rankingNacional"
                      class="custom-control-input"
                      id="rankingNacional4"
                      type="radio"
                      value="4"
                      v-model="rankingNacional"
                      v-on:click="rnkError = false"
                    >
                    <label class="custom-control-label" for="rankingNacional4">4</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="rankingNacional"
                      class="custom-control-input"
                      id="rankingNacional5"
                      type="radio"
                      value="5"
                      v-model="rankingNacional"
                      v-on:click="rnkError = false"
                    >
                    <label class="custom-control-label" for="rankingNacional5">5</label>
                  </div>
                </div>
              </div>
              <p class="text-danger" v-show="rnkError">INDICA UN NIVEL DE IMPORTANCIA</p>
              <br>
              <h5
                style="font-weight: bold;"
                :class="{'text-danger': becasError}"
              >Becas (económicas)*</h5>
              <div class="row">
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="becas"
                      class="custom-control-input"
                      id="becas1"
                      type="radio"
                      value="1"
                      v-model="becas"
                      v-on:click="becasError = false"
                    >
                    <label class="custom-control-label" for="becas1">1</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="becas"
                      class="custom-control-input"
                      id="becas2"
                      type="radio"
                      value="2"
                      v-model="becas"
                      v-on:click="becasError = false"
                    >
                    <label class="custom-control-label" for="becas2">2</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="becas"
                      class="custom-control-input"
                      id="becas3"
                      type="radio"
                      value="3"
                      v-model="becas"
                      v-on:click="becasError = false"
                    >
                    <label class="custom-control-label" for="becas3">3</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="becas"
                      class="custom-control-input"
                      id="becas4"
                      type="radio"
                      value="4"
                      v-model="becas"
                      v-on:click="becasError = false"
                    >
                    <label class="custom-control-label" for="becas4">4</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="becas"
                      class="custom-control-input"
                      id="becas5"
                      type="radio"
                      value="5"
                      v-model="becas"
                      v-on:click="becasError = false"
                    >
                    <label class="custom-control-label" for="becas5">5</label>
                  </div>
                </div>
              </div>
              <p class="text-danger" v-show="becasError">INDICA UN NIVEL DE IMPORTANCIA</p>
              <br>
              <h5
                style="font-weight: bold;"
                :class="{'text-danger': anosError}"
              >Años de acreditación*</h5>
              <div class="row">
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="anosAcreditacion"
                      class="custom-control-input"
                      id="anosAcreditacion1"
                      type="radio"
                      value="1"
                      v-model="anosAcreditacion"
                      v-on:click="anosError = false"
                    >
                    <label class="custom-control-label" for="anosAcreditacion1">1</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="anosAcreditacion"
                      class="custom-control-input"
                      id="anosAcreditacion2"
                      type="radio"
                      value="2"
                      v-model="anosAcreditacion"
                      v-on:click="anosError = false"
                    >
                    <label class="custom-control-label" for="anosAcreditacion2">2</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="anosAcreditacion"
                      class="custom-control-input"
                      id="anosAcreditacion3"
                      type="radio"
                      value="3"
                      v-model="anosAcreditacion"
                      v-on:click="anosError = false"
                    >
                    <label class="custom-control-label" for="anosAcreditacion3">3</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="anosAcreditacion"
                      class="custom-control-input"
                      id="anosAcreditacion4"
                      type="radio"
                      value="4"
                      v-model="anosAcreditacion"
                      v-on:click="anosError = false"
                    >
                    <label class="custom-control-label" for="anosAcreditacion4">4</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      name="anosAcreditacion"
                      class="custom-control-input"
                      id="anosAcreditacion5"
                      type="radio"
                      value="5"
                      v-model="anosAcreditacion"
                      v-on:click="anosError = false"
                    >
                    <label class="custom-control-label" for="anosAcreditacion5">5</label>
                  </div>
                </div>
              </div>
              <p class="text-danger" v-show="anosError">INDICA UN NIVEL DE IMPORTANCIA</p>
              <br>
              <h5
                style="font-weight: bold;"
                :class="{'text-danger': cercaniaError}"
              >Cercanía al lugar de residencia*</h5>
              <div class="row">
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      class="custom-control-input"
                      id="cercania1"
                      type="radio"
                      value="1"
                      v-model="cercania"
                      v-on:click="cercaniaError = false"
                    >
                    <label class="custom-control-label" for="cercania1">1</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      class="custom-control-input"
                      type="radio"
                      id="cercania2"
                      value="2"
                      v-model="cercania"
                      v-on:click="cercaniaError = false"
                    >
                    <label class="custom-control-label" for="cercania2">2</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      class="custom-control-input"
                      type="radio"
                      id="cercania3"
                      value="3"
                      v-model="cercania"
                      v-on:click="cercaniaError = false"
                    >
                    <label class="custom-control-label" for="cercania3">3</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      class="custom-control-input"
                      id="cercania4"
                      type="radio"
                      value="4"
                      v-model="cercania"
                      v-on:click="cercaniaError = false"
                    >
                    <label class="custom-control-label" for="cercania4">4</label>
                  </div>
                </div>
                <div class="col-sm">
                  <div class="custom-control custom-radio mb-3">
                    <input
                      class="custom-control-input"
                      id="cercania5"
                      type="radio"
                      value="5"
                      v-model="cercania"
                      v-on:click="cercaniaError = false"
                    >
                    <label class="custom-control-label" for="cercania5">5</label>
                  </div>
                </div>
              </div>
              <p class="text-danger" v-show="cercaniaError">INDICA UN NIVEL DE IMPORTANCIA</p>
              <br>
              <br>
              <badger-accordion>
                <badger-accordion-item>
                  <template slot="header">
                    <h5 style="font-weight: bold;">Escoge tu(s) carrera(s) de interés (opcional)</h5>
                  </template>
                  <template slot="content">
                    <div
                      class="col-sm custom-control custom-checkbox"
                      v-for="carrera of carreras"
                      v-bind:key="carrera.id"
                    >
                      <input
                        class="mb-3 custom-control-input"
                        type="checkbox"
                        :id="carrera.id"
                        :value="carrera.id"
                        v-model="carrerasSeleccionadas"
                      >
                      <label class="mb-3 custom-control-label" :for="carrera.id">{{ carrera.name }}</label>
                    </div>
                  </template>
                </badger-accordion-item>
              </badger-accordion>
              <br>
              <h5 style="font-weight: bold;">Selecciona tu ubicación</h5>
              <gmap-autocomplete
                placeholder="Introduce una dirección o lugar"
                class="input-group-text form-control text-black"
                @place_changed="setPlace"
              ></gmap-autocomplete>
              <gmap-map
                v-on:click="mapClick"
                :center="geolocation"
                :zoom="zoom"
                style="width:100%;  height: 400px;"
              >
                <gmap-marker :position="marker.position" @click="geolocation=marker.position"></gmap-marker>
              </gmap-map>
              <br>
              <base-button
                type="default"
                round
                block
                size="lg"
                v-on:click="obtenerRecomendacion()"
              >Obtener recomendación</base-button>
            </card>
            <br>
            <div id="section_recomendacion">
              <recomendacion v-if="recomendacionesHechas" :recomendaciones="recomendaciones"></recomendacion>
            </div>
          </div>
        </div>
      </div>
    </section>
    <loading :active.sync="isLoading" :is-full-page="true"></loading>
  </div>
</template>

<style>
.text-black {
  color: black;
  font-size: 1.2rem;
}
</style>

<script>
import {
  careersServices,
  universitiesServices,
  surveyServices
} from "../services";

import { BadgerAccordion, BadgerAccordionItem } from "vue-badger-accordion";
import Loading from "vue-loading-overlay";
import "vue-loading-overlay/dist/vue-loading.css";
import Recomendacion from "./components/Recomendacion";
import Modal from "../components/Modal";

var utils = require("../plugins/utils");

export default {
  name: "home",
  components: {
    BadgerAccordion,
    BadgerAccordionItem,
    Loading,
    Recomendacion,
    Modal
  },
  data() {
    return {
      utils: utils,
      name: "",
      cercania: 0,
      anosAcreditacion: 0,
      becas: 0,
      rankingNacional: 0,
      carreras: [],
      universidades: [],
      carrerasSeleccionadas: [],
      rnkError: false,
      anosError: false,
      cercaniaError: false,
      becasError: false,
      error: false,
      errorLocation: false,
      marker: {},
      geolocation: { lat: -33.4488897, lng: -70.6692655 },
      zoom: 9,
      isLoading: false,
      recomendaciones: [],
      recomendacionesHechas: false,
      modals: {
        universidades: false,
        carreras: false
      }
    };
  },
  async mounted() {
    this.isLoading = true;
    await careersServices
      .getAll()
      .then(response => {
        this.carreras = response;
      })
      .catch(response => {
        this.carreras = [];
      });

    await universitiesServices
      .getAll()
      .then(response => {
        this.universidades = response;
      })
      .catch(response => {
        this.universidades = [];
      });

    this.geolocate();
    this.isLoading = false;
  },
  methods: {
    obtenerRecomendacion() {
      this.recomendacionesHechas = false;
      this.isLoading = true;
      if (this.validarFormulario()) {
        this.isLoading = false;
        return;
      }

      var survey = {
        ptsBca: this.becas,
        ptsAcr: this.anosAcreditacion,
        ptsRank: this.rankingNacional,
        ptsNear: this.cercania,
        careerId: this.carrerasSeleccionadas,
        lat: this.geolocation.lat,
        lng: this.geolocation.lng
      };

      this.recomendaciones = [];

      surveyServices
        .getRecommend(survey)
        .then(response => {
          response.forEach(universidad => {
            this.recomendaciones.push(universidad);
          });
          this.recomendacionesHechas = true;
          this.$scrollTo("#section_recomendacion", 800, []);
          this.isLoading = false;
        })
        .catch(error => {
          this.isLoading = false;
        });
    },
    validarFormulario() {
      var error = false;
      if (this.cercania == 0) {
        this.cercaniaError = true;
        error = true;
      }
      if (this.anosAcreditacion == 0) {
        this.anosError = true;
        error = true;
      }
      if (this.becas == 0) {
        this.becasError = true;
        error = true;
      }
      if (this.rankingNacional == 0) {
        this.rnkError = true;
        error = true;
      }
      this.error = error;
      if (error) this.$scrollTo("#form-card", 800, []);
      return error;
    },
    setPlace(place) {
      const coords = {
        lat: place.geometry.location.lat(),
        lng: place.geometry.location.lng()
      };
      this.zoom = 14;
      this.addMarker(coords);
    },
    addMarker(coords) {
      this.marker = {
        position: {
          lat: coords.lat,
          lng: coords.lng
        }
      };
      this.geolocation = {
        lat: coords.lat,
        lng: coords.lng
      };
    },
    geolocate: function() {
      navigator.geolocation.getCurrentPosition(position => {
        this.geolocation = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };
        this.addMarker(this.geolocation);
      });
      this.addMarker(this.geolocation);
    },
    mapClick(click) {
      this.addMarker({
        lat: click.latLng.lat(),
        lng: click.latLng.lng()
      });
    }
  }
};
</script>
