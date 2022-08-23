import { createApp } from 'vue'
import App from './App.vue'
import { Button, Form, Input, InputNumber, Modal, Table } from 'ant-design-vue'

const app = createApp(App)
app.use(Table)
app.use(Button)
app.use(Modal)
app.use(Form)
app.use(Input)
app.use(InputNumber)
app.mount('#app')
