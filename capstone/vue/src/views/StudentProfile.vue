<template>
  <div>
      <student-detail v-bind:studentId="parseInt($route.params.id)" />
  </div>
</template>

<script>
import StudentDetail from '../components/StudentDetail.vue'

export default {
    name: "StudentProfile",
    components: { StudentDetail },

}
</script>

<style>

</style>