<template>
  <div>
      <student-detail v-bind:studentId="parseInt($route.params.id)" />
      <student-kudos v-bind:studentId="parseInt($route.params.id)" />
      <student-classes v-bind:studentId="parseInt($route.params.id)" />
  </div>
</template>

<script>
import StudentClasses from '../components/StudentClasses.vue'
import StudentDetail from '../components/StudentDetail.vue'
import StudentKudos from '../components/StudentKudos.vue'

export default {
    name: "StudentProfile",
    components: { StudentDetail, StudentKudos, StudentClasses },

}
</script>

<style>

</style>