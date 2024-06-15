<script setup>
import { ref } from 'vue';
import { useModal } from 'vue-final-modal';
import StudentFormModal from './StudentFormModal.vue';
import ScoreFormModal from './ScoreFormModal.vue';

const students = ref([])
const selectedStudent = ref()

const fetchStudents = async () => {
  const data = await fetch('/students/list')
  if (!data.ok) {
    console.error(data.statusText)
    return
  }
  students.value = await data.json()
}

fetchStudents()

const studentScores = (student) => {
  if (!student.student_scores || !student.student_scores.length) return

  return student.student_scores[0]
}

const calculateGrade = (student) => {
  const score = studentScores(student)
  if (!score) return
  const calculated = 0.3 * score.score1 + 0.7 * score.score2
  switch (true) {
    case calculated >= 8:
      return 'A'
    case calculated >= 6:
      return 'B'
    case calculated >= 4:
      return 'D'
    default:
      return 'F'
  }
}

const { open: openModalStudent, close: closeModalStudent } = useModal({
  component: StudentFormModal,
  attrs: {
    student: selectedStudent,
    onSubmit: () => {
      closeModalStudent()
      fetchStudents()
    },
  },
})

const { open: openModalScore, close: closeModalScore } = useModal({
  component: ScoreFormModal,
  attrs: {
    onSubmit: () => {
      closeModalScore()
      fetchStudents()
    },
  },
})

const onCreateStudent = () => {
  selectedStudent.value = undefined
  openModalStudent()
}

const onEditStudent = (student) => {
  selectedStudent.value = student
  openModalStudent()
}
</script>

<template>
  <h1 class="header">Student Information System</h1>
  <h2 class="sub-header">Student Information</h2>
  <div>
    <button class="btn-add" @click="onCreateStudent"> + Student </button>
    <button class="btn-add" @click="openModalScore"> + Score </button>
  </div>
  <table class="student-table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Student code</th>
        <th>Student Name</th>
        <th>Subject Name</th>
        <th>Score 1</th>
        <th>Score 2</th>
        <th>Credit</th>
        <th>Grade</th>
        <th></th>
      </tr>
    </thead>
    <tbody v-if="students.length > 0">
      <tr v-for="student in students" :key="student.student_id">
        <td>{{ student.student_id }}</td>
        <td>{{ student.student_code }}</td>
        <td>{{ student.full_name }}</td>
        <td>{{ studentScores(student)?.subject.subject_name }}</td>
        <td>{{ studentScores(student)?.score1 }}</td>
        <td>{{ studentScores(student)?.score2 }}</td>
        <td>{{ studentScores(student)?.subject.credit }}</td>
        <td>{{ calculateGrade(student) }}</td>
        <td>
          <button @click="onEditStudent(student)">Edit</button>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<style scoped>
.header {
  color: white;
  background: green;
  padding-inline: 10px;
  padding-block: 5px;
}

.sub-header {
  text-align: center;
  color: green;
  font-size: 2em;
}

.btn-add {
  background: green;
  color: white;
  border: none;
  padding-inline: 20px;
  padding-block: 5px;
  border-radius: 5px;
  cursor: pointer;
}

.btn-add + .btn-add {
  margin-left: 10px;
}

.student-table {
  width: 100%;
  thead {
    tr {
      background: green;
      color: white;
    }
    th {
      text-align: left;
    }
  }
}
</style>
