<script setup>
import Modal from './Modal.vue'

const emits = defineEmits(['submit'])

const createScore = async (body) => {
  await fetch('/student-score/add', {
    method: 'POST',
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
  console.log(formProps)
  if (!formProps) return;

  try {
    await createScore(formProps)
    emits('submit')
  } catch (e) {
    console.log(e.message)
  }
}
</script>

<template>
  <Modal>
    <form @submit.prevent="onSubmit">
      <div class="form-control">
        <label for="student_id">Student Id</label>
        <input type="text" name="student_id" id="student_id" required />
      </div>
      <div class="form-control">
        <label for="subject_id">Subject Id</label>
        <input type="text" name="subject_id" id="subject_id" required />
      </div>
      <div class="form-control">
        <label for="score1">Score1</label>
        <input type="text" name="score1" id="score1" required />
      </div>
      <div class="form-control">
        <label for="score2">Score2</label>
        <input type="text" name="score2" id="score2" required />
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
