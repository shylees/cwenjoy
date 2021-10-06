import 'element-ui/lib/theme-chalk/index.css';
import ElementUI from 'element-ui';

import 'muse-ui/dist/muse-ui.css';
import MuseUI from 'muse-ui';
import 'muse-ui-toast/dist/muse-ui-toast.all.css'
import Toast from 'muse-ui-toast';
import 'muse-ui-message/dist/muse-ui-message.css';
import Message from 'muse-ui-message';

import SuiVue from 'semantic-ui-vue';
import 'semantic-ui-css/semantic.min.css';

import Vue from 'vue'
import router from './router'
import App from './App'
// import Helpers from 'muse-ui/lib/Helpers';

Vue.config.productionTip = false

Vue.use(ElementUI, { size: 'small', zIndex: 3000 });
Vue.use(MuseUI);
Vue.use(Toast);
Vue.use(Message);
// Vue.use(Helpers);
Vue.use(SuiVue);

new Vue({
  el: '#app',
  router,
  render: h => h(App),
  
})
