<template>
  <div>
      <staff-detail v-bind:staffId="parseInt($route.params.id)" />
      <teacher-classes v-bind:staffId="parseInt($route.params.id)" />
      
  </div>
</template>

<script>
import StaffDetail from '../components/StaffDetail.vue'
import TeacherClasses from '../components/TeacherClasses.vue'

export default {
  components: { TeacherClasses, StaffDetail},

}
</script>,
    CreateClass

<style>

</style>