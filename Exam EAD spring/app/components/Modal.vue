<script setup>
import { VueFinalModal } from 'vue-final-modal'

defineEmits('close')
</script>

<template>
  <VueFinalModal
    class="modal"
    content-class="modal-content"
    overlay-transition="vfm-fade"
    content-transition="vfm-fade"
  >
    <slot />
  </VueFinalModal>
</template>

<style>
.modal {
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal-content {
  display: flex;
  flex-direction: column;
  padding: 1rem;
  background: #fff;
  border-radius: 0.5rem;
}
</style>
