import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import Argon from "./plugins/argon-kit";
import './registerServiceWorker'

import VueScrollTo from "vue-scrollto";
Vue.use(VueScrollTo);

import VueGeolocation from 'vue-browser-geolocation';
Vue.use(VueGeolocation);

// You can also pass in the default options
Vue.use(VueScrollTo, {
     container: "body",
     duration: 500,
     easing: "ease",
     offset: 0,
     force: true,
     cancelable: true,
     onStart: false,
     onDone: false,
     onCancel: false,
     x: false,
     y: true
 });

import * as VueGoogleMaps from 'vue2-google-maps' 
Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyBFTHlPAi8q7pOzgmd0kqpmn4MbiKsw-2M',
    libraries: 'places'
  }
})

Vue.config.productionTip = false;
Vue.use(Argon);
new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
