<script setup>
import Modal from './Modal.vue'

defineProps({
  student: {
    type: Object,
    default: () => ({})
  }
})

const emits = defineEmits(['submit'])

const createStudent = async (body) => {
  await fetch('/students/add', {
    method: 'POST',
    body: JSON.stringify(body),
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  })
}

const editStudent = async (body) => {
  await fetch('/students/update', {
    method: 'PUT',
    body: JSON.stringify(body),
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  })
}

const onSubmit = async (e) => {
  const formData = new FormData(e.target);
  const formProps = Object.fromEntries(formData);
  if (!formProps) return;

  try {
    if (formProps.student_id) await editStudent(formProps)
    else await createStudent(formProps)

    emits('submit')
  } catch (e) {
    console.log(e.message)
  }
}
</script>

<template>
  <Modal>
    <form @submit.prevent="onSubmit">
      <input :value="student.student_id" type="text" name="student_id" id="student_id" readonly style="display: none;" />
      <div class="form-control">
        <label for="student_code">Student Code</label>
        <input :value="student.student_code" type="text" name="student_code" id="student_code" required />
      </div>
      <div class="form-control">
        <label for="full_name">Full Name</label>
        <input :value="student.full_name" type="text" name="full_name" id="full_name" required />
      </div>
      <div class="form-control">
        <label for="address">Address</label>
        <input :value="student.address" type="text" name="address" id="address" required />
      </div>
      <button type="submit">Create</button>
    </form>
  </Modal>
</template>

<style scoped>
.form-control {
  margin: 10px 0;
  display: flex;
  flex-direction: column;
}
</style>
