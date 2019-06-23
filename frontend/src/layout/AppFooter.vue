<template>
  <footer class="footer has-cards">
    <section class="section section-lg pt-0">
      <div class="container">
        <card gradient="warning" no-body shadow-size="lg" class="border-0">
          <div class="p-5">
            <div class="row align-items-center">
              <div class="col-lg-8">
                <h3 class="text-white">¿Quieres ayudar al proyecto?</h3>
                <p
                  class="lead text-white mt-3"
                >Con gusto recibimos retroalimentación de todos los actores involucrados, estudiantes, futuros estudiantes, universidades, etc.</p>
              </div>
              <div class="col-lg-4 ml-lg-auto">
                <base-button
                  block
                  type="white"
                  class="mb-2"
                  @click="modals.retroalimentacion = true"
                >Enviar Retroalimentacion</base-button>
              </div>
            </div>
          </div>
        </card>
      </div>
    </section>

    <modal
      :show.sync="modals.retroalimentacion"
      body-classes="p-0"
      modal-classes="modal-dialog-centered modal-sm"
    >
      <card
        type="secondary"
        shadow
        header-classes="bg-white pb-5"
        body-classes="px-lg-5 py-lg-5"
        class="border-0"
      >
        <template>
          <div class="text-center mb-3">
            <small>Envía tu retroalimentación!</small>
          </div>
        </template>
        <template>
          <form role="form">
            <base-input
              alternative
              class="mb-3"
              placeholder="Tu nombre"
              addon-left-icon="ni ni-person-83"
              v-model="form.nombre"
              require
            ></base-input>
            <p class="text-danger" v-if="errors.nombre">Falta un nombre</p>
            <base-input
              alternative
              type="email"
              placeholder="Email"
              addon-left-icon="ni ni-email-83"
              v-model="form.email"
              require
            ></base-input>
            <p class="text-danger" v-if="errors.email">Falta un email o es inválido</p>
            <textarea
              require
              class="form-control"
              v-model="form.mensaje"
              rows="4"
              placeholder="Escribe tu mensaje"
            ></textarea>
            <p class="text-danger" v-if="errors.mensaje">Falta el mensaje</p>
            <div class="text-center">
              <base-button type="success" class="my-4" @click="sendRetroalimentacion" :disabled="isLoading">Enviar</base-button>
              <base-button
                type="white"
                class="ml-auto"
                @click="modals.retroalimentacion = false"
              >Cerrar</base-button>
            </div>
          </form>
        </template>
      </card>
      <base-alert type="success" v-if="showSuccessEmail" dismissible>
      <span class="alert-inner--icon">
        <i class="ni ni-like-2"></i>
      </span>
      <span class="alert-inner--text">
        <strong>Listo!</strong> Muchas gracias por tu retroalimentación! La leeremos con cuidado.
      </span>
    </base-alert>

    <base-alert type="warning" v-if="showErrorEmail" dismissible>
      <span class="alert-inner--icon">
        <i class="ni ni-bulb-61"></i>
      </span>
      <span class="alert-inner--text">
        <strong>Error!</strong> No se envío la retroalimentación, prueba mas tarde
      </span>
    </base-alert>
    </modal>

    

    <div class="container">
      <div class="row row-grid align-items-center my-md">
        <div class="col-lg-6">
          <h3 class="text-primary font-weight-light mb-2">Gracias por tu apoyo!</h3>
          <h4 class="mb-0 font-weight-light">Esperamos que esta plataforma sea de ayuda.</h4>
        </div>
      </div>
      <hr>
      <div class="row align-items-center justify-content-md-between">
        <div class="col-md-6">
          <div class="copyright">
            &copy; {{year}}
            <a href="http://www.softultra.cl">Softultra</a>
          </div>
        </div>
      </div>
    </div>
    <loading :active.sync="isLoading" :is-full-page="true"></loading>
  </footer>
</template>
<script>
import Modal from "../components/Modal";
import * as emailjs from "emailjs-com";
import Loading from "vue-loading-overlay";
import "vue-loading-overlay/dist/vue-loading.css";

export default {
  name: "app-footer",
  components: {
    Modal,
    Loading
  },
  data() {
    return {
      year: new Date().getFullYear(),
      modals: {
        retroalimentacion: false
      },
      form: {
        nombre: "",
        email: "",
        mensaje: ""
      },
      errors: {
        nombre: false,
        email: false,
        mensaje: false
      },
      showSuccessEmail: false,
      showErrorEmail: false,
      isLoading: false
    };
  },
  created() {
    emailjs.init("user_gbjd7gHSGQ3kOAcqgEc9b");
  },
  methods: {
    sendRetroalimentacion() {
      this.form.nombre == "" ? this.errors.nombre = true : this.errors.nombre = false;
      this.form.email == "" ? this.errors.email = true : this.errors.email = false;
      this.form.mensaje == "" ? this.errors.mensaje = true : this.errors.mensaje = false;

      if (this.errors.nombre || this.errors.email || this.errors.mensaje)
        return;

      this.isLoading = true;
      var template_params = {
        reply_to: this.form.email,
        from_name: this.form.nombre,
        message_html: this.form.mensaje
      };
      var service_id = "default_service";
      var template_id = "template_fLAWCZ7H";
      emailjs.send(service_id, template_id, template_params).then(
        response => {
        this.isLoading = false;
          this.showSuccessEmail = true;
          this.form.email = "";
          this.form.nombre = "";
          this.form.mensaje = "";
          this.disableButton = false;
        },
        err => {
        this.isLoading = false;
          this.showErrorEmail = true;
          this.disableButton = false;
        }
      );
    }
  }
};
</script>
<style>
</style>
