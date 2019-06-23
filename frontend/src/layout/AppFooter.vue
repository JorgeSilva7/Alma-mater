<template>
    <footer class="footer has-cards">
        <section class="section section-lg pt-0">
            <div class="container">
                <card gradient="warning"
                      no-body
                      shadow-size="lg"
                      class="border-0">
                    <div class="p-5">
                        <div class="row align-items-center">
                            <div class="col-lg-8">
                                <h3 class="text-white">¿Quieres ayudar al proyecto?</h3>
                                <p class="lead text-white mt-3">Con gusto recibimos retroalimentación de todos los actores involucrados, estudiantes, futuros estudiantes, universidades, etc.</p>
                            </div>
                            <div class="col-lg-4 ml-lg-auto">
                                <base-button type="white" block size="lg">
                                    Enviar Retroalimentacion
                                </base-button>
                            </div>
                        </div>
                    </div>
                </card>
            </div>
        </section>
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
    </footer>
</template>
<script>
export default {
  name: 'app-footer',
  data() {
    return {
      year: new Date().getFullYear()
    }
  }
};
</script>
<style>
</style>
