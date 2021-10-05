

import 'element-ui/lib/theme-chalk/index.css';
import 'muse-ui/dist/muse-ui.css';
import 'muse-ui-toast/dist/muse-ui-toast.all.css'
import 'muse-ui-message/dist/muse-ui-message.css';

import Vue from 'vue'
import router from './router'
import ElementUI from 'element-ui';
import MuseUI from 'muse-ui';
import Toast from 'muse-ui-toast';
import Message from 'muse-ui-message';
import App from './App'


Vue.config.productionTip = false

Vue.use(ElementUI, { size: 'small', zIndex: 3000 });
Vue.use(MuseUI);
Vue.use(Toast);
Vue.use(Message);

new Vue({
  el: '#app',
  router,
  render: h => h(App),
  
})
