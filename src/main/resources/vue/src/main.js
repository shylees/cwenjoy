import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import MuseUI from 'muse-ui';
import 'muse-ui/dist/muse-ui.css';
import App from './App'

Vue.config.productionTip = false

Vue.use(ElementUI, { size: 'small', zIndex: 3000 });
Vue.use(MuseUI);

new Vue({
  el: '#app',
  render: h => h(App)
})
