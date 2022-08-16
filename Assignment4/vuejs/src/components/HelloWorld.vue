<template>
  <div class="contener">
    <a-button type="primary" @click="openModal(false)">Add Employee</a-button>
    <a-table :data-source="employees" :columns="columns" style="margin-top: 20px" :pagination="pagination">
      <template #bodyCell="{ column, record }">
        <template v-if="column.key === 'action'">
          <a-button style="background-color: yellow" @click="openModal(record.id)">Edit</a-button>
          <a-button type="danger" style="margin-left: 20px" @click="deleteEmployee(record.id)">Delete</a-button>
        </template>
      </template>
    </a-table>
    <a-modal v-model:visible="visible" :title="`${isEdit ? 'Edit' : 'Add'} Employee`" :footer="null">
      <a-form
          :model="formState"
          name="basic"
          :label-col="{ span: 8 }"
          :wrapper-col="{ span: 16 }"
          autocomplete="off"
          @finish="handleSubmit"
      >
        <a-form-item
            label="Name"
            name="name"
            :rules="[{ required: true, message: 'Please input name!' }]"
        >
          <a-input v-model:value="formState.name" />
        </a-form-item>
        <a-form-item
            label="Age"
            name="wage"
            :rules="[
              { required: true, message: 'Please input age!' },
              { type: 'integer', message: 'Please input number!'},
          ]"
        >
          <a-input-number v-model:value="formState.wage" min="0" style="width: 100%"/>
        </a-form-item>
        <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
          <a-button type="primary" html-type="submit">
            {{ isEdit ? 'Edit' : 'Add' }}</a-button>
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script>
import axios
  from "axios";
import {
  defineComponent,
  onMounted,
  reactive,
  ref
} from "vue";

const columns = [
  {
    title: 'Id',
    dataIndex: 'id',
    key: 'id',
    width: '10%',
  },
  {
    title: 'Name',
    dataIndex: 'name',
    key: 'name',
    width: '30%',
  },
  {
    title: 'Age',
    dataIndex: 'wage',
    key: 'wage',
    width: '30%'
  },
  {
    title: 'Action',
    key: 'action',
  }
]

const pagination = {
  position: 'topRight',
  pageSize: 5
}

export default defineComponent({
  setup() {
    const initialState = {
      id: null,
      name: null,
      wage: null
    }
    const formState = reactive({...initialState})
    const visible = ref(false)
    const loading = ref(false)
    const isEdit = ref(false)
    const employees = ref([])

    const baseUrl = process.env.VUE_APP_BASE_URL

    const getEmployees = async () => {
      if (loading.value) return
      try {
        loading.value = true
        const res = await axios.get(`${baseUrl}/employees`)
        employees.value = res.data
      } catch (e) {
        console.log(e)
      } finally {
        loading.value = false
      }
    }

    const createEmployees = async () => {
      if (loading.value) return
      try {
        loading.value = true
        const res = await axios.post(`${baseUrl}/employees`, formState)
        employees.value.push(res.data)
        visible.value = false
      } catch (e) {
        console.log(e)
      } finally {
        loading.value = false
      }
    }

    const editEmployees = async () => {
      if (loading.value) return
      try {
        loading.value = true
        const res = await axios.put(`${baseUrl}/employees/${formState.id}`, formState)
        employees.value.push(res.data)
        visible.value = false
      } catch (e) {
        console.log(e)
      } finally {
        loading.value = false
        isEdit.value = false
      }
      await getEmployees()
    }

    const deleteEmployee = async (id) => {
      if (loading.value) return
      try {
        loading.value = true
        await axios.delete(`${baseUrl}/employees/${id}`)
      } catch (e) {
        console.log(e)
      } finally {
        loading.value = false
      }
      await getEmployees()
    }

    const openModal = (id = null) => {
      Object.assign(formState, initialState)
      if (id) {
        isEdit.value = true
        const employee = employees.value.find((val) => val.id === id)
        formState.id = employee?.id
        formState.name = employee?.name
        formState.wage = employee?.wage
      }
      visible.value = true
    }

    const handleSubmit = () => {
      if (!isEdit.value) {
        createEmployees()
      } else {
        editEmployees()
      }
    }

    onMounted(() => {
      getEmployees()
    })

    return {
      employees,
      columns,
      visible,
      formState,
      isEdit,
      pagination,
      deleteEmployee,
      openModal,
      handleSubmit
    };
  }
})
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.contener {
  max-width: 80%;
  margin: 0 auto;
}
</style>
