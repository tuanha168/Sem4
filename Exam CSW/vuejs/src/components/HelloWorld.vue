<template>
  <div class="contener">
    <a-button type="primary" @click="openModal(false)">Add Product</a-button>
    <a-table
      :data-source="products"
      :columns="columns"
      style="margin-top: 20px"
      :pagination="pagination">
      <template #bodyCell="{ column, record }">
        <template v-if="column.key === 'action'">
          <a-button
            style="background-color: green; color: white"
            @click="openModalSell(record.id)"
            >Sell</a-button
          >
          <a-button
            style="margin-left: 20px; background-color: yellow"
            @click="openModal(record.id)"
            >Edit</a-button
          >
          <a-button
            type="danger"
            style="margin-left: 20px"
            @click="deleteProduct(record.id)"
            >Delete</a-button
          >
        </template>
      </template>
    </a-table>
    <a-modal
      v-model:visible="visibleSellModal"
      :title="`Sell Product`"
      :footer="null">
      <a-form
        :model="sellForm"
        name="basic"
        :label-col="{ span: 8 }"
        :wrapper-col="{ span: 16 }"
        autocomplete="off"
        @finish="sellProduct">
        <a-form-item
          v-if="sellForm.maxQuantity"
          label="Quantity"
          name="quantity"
          :rules="[
            { required: true, message: 'Please input quantity!' },
            { type: 'number', message: 'Please input number!' },
            { type: 'number', max: sellForm.maxQuantity, message: 'Out of Stock!' }
          ]">
          <a-input-number
            v-model:value="sellForm.quantity"
            min="0"
            style="width: 100%" />
        </a-form-item>
        <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
          <a-button type="primary" html-type="submit">Sell</a-button>
        </a-form-item>
      </a-form>
    </a-modal>
    <a-modal
      v-model:visible="visible"
      :title="`${isEdit ? 'Edit' : 'Add'} Product`"
      :footer="null">
      <a-form
        :model="formState"
        name="basic"
        :label-col="{ span: 8 }"
        :wrapper-col="{ span: 16 }"
        autocomplete="off"
        @finish="handleSubmit">
        <a-form-item
          label="Name"
          name="name"
          :rules="[{ required: true, message: 'Please input name!' }]">
          <a-input v-model:value="formState.name" />
        </a-form-item>
        <a-form-item
          label="Price"
          name="price"
          :rules="[
            { required: true, message: 'Please input price!' },
            { type: 'integer', message: 'Please input number!' }
          ]">
          <a-input-number
            v-model:value="formState.price"
            min="0"
            style="width: 100%" />
        </a-form-item>
        <a-form-item
          label="Quantity"
          name="quantity"
          :rules="[
            { required: true, message: 'Please input quantity!' },
            { type: 'integer', message: 'Please input number!' }
          ]">
          <a-input-number
            v-model:value="formState.quantity"
            min="0"
            style="width: 100%" />
        </a-form-item>
        <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
          <a-button type="primary" html-type="submit">
            {{ isEdit ? 'Edit' : 'Add' }}</a-button
          >
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script>
import axios from 'axios'
import { defineComponent, onMounted, reactive, ref } from 'vue'

const columns = [
  {
    title: 'Id',
    dataIndex: 'id',
    key: 'id',
    width: '10%'
  },
  {
    title: 'Name',
    dataIndex: 'name',
    key: 'name',
    width: '15%'
  },
  {
    title: 'Price',
    dataIndex: 'price',
    key: 'price',
    width: '15%'
  },
  {
    title: 'Quantity',
    dataIndex: 'quantity',
    key: 'quantity',
    width: '30%'
  },
  {
    title: 'Action',
    key: 'action'
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
      price: null,
      quantity: null,
      maxQuantity: null
    }
    const initialStateSellForm = {
      id: null,
      quantity: null
    }
    const formState = reactive({ ...initialState })
    const sellForm = reactive({ ...initialStateSellForm })
    const visible = ref(false)
    const visibleSellModal = ref(false)
    const loading = ref(false)
    const isEdit = ref(false)
    const products = ref([])

    const baseUrl = process.env.VUE_APP_BASE_URL

    const getProducts = async () => {
      if (loading.value) return
      try {
        loading.value = true
        const res = await axios.get(`${baseUrl}/products`)
        products.value = res.data
      } catch (e) {
        console.log(e)
      } finally {
        loading.value = false
      }
    }

    const createProduct = async () => {
      if (loading.value) return
      try {
        loading.value = true
        console.log(123)
        const res = await axios.post(`${baseUrl}/products`, formState)
        products.value.push(res.data)
        visible.value = false
      } catch (e) {
        console.log(e)
      } finally {
        loading.value = false
      }
    }

    const editProduct = async () => {
      if (loading.value) return
      try {
        loading.value = true
        await axios.put(`${baseUrl}/products/${formState.id}`, formState)
        visible.value = false
      } catch (e) {
        console.log(e)
      } finally {
        loading.value = false
        isEdit.value = false
      }
      await getProducts()
    }

    const deleteProduct = async (id) => {
      if (loading.value) return
      try {
        loading.value = true
        await axios.delete(`${baseUrl}/products/${id}`)
      } catch (e) {
        console.log(e)
      } finally {
        loading.value = false
      }
      await getProducts()
    }

    const openModal = (id = null) => {
      Object.assign(formState, initialState)
      isEdit.value = !!id
      if (id) {
        const product = products.value.find((val) => val.id === id)
        formState.id = product?.id
        formState.name = product?.name
        formState.price = product?.price
        formState.quantity = product?.quantity
      }
      visible.value = true
    }

    const openModalSell = (id = null) => {
      Object.assign(sellForm, initialStateSellForm)
      if (id) {
        const product = products.value.find((val) => val.id === id)
        sellForm.id = product?.id
        sellForm.name = product?.name
        sellForm.price = product?.price
        sellForm.maxQuantity = product?.quantity
        visibleSellModal.value = true
      }
    }

    const handleSubmit = () => {
      if (!isEdit.value) {
        createProduct()
      } else {
        editProduct()
      }
    }

    const sellProduct = async () => {
      if (loading.value) return
      try {
        loading.value = true
        await axios.put(`${baseUrl}/products/sell/${sellForm.id}`, { quantity: sellForm.quantity })
        visible.value = false
      } catch (e) {
        console.log(e)
      } finally {
        loading.value = false
        isEdit.value = false
      }
      await getProducts()
    }

    onMounted(() => {
      getProducts()
    })

    return {
      products,
      columns,
      visible,
      visibleSellModal,
      formState,
      sellForm,
      isEdit,
      pagination,
      deleteProduct,
      openModal,
      openModalSell,
      handleSubmit,
      sellProduct
    }
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
