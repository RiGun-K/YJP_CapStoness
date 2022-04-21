import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'
import {router} from './router'
import store from './store';

import Datepicker from '@vuepic/vue-datepicker'
import '@vuepic/vue-datepicker/dist/main.css'

axios.defaults.headers.common['Access-Controle_Allow-Origin'] = '*'
axios.defaults.headers.get['Content-Type'] = 'application/json;charset=utf-8'

createApp(App).mount('#app')
App.use(router)
App.use(store);
App.component('Datepicker', Datepicker)
App.mount('#app')
App.config.globalProperties.axios = axios