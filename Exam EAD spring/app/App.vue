<script setup>
import StudentList from './components/StudentList.vue';
import { ModalsContainer } from 'vue-final-modal'
</script>

<template>
  <Suspense>
    <StudentList />
  </Suspense>
  <ModalsContainer />
</template>
