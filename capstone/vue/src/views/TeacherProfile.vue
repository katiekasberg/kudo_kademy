<template>
  <body>
    <div>
      <staff-detail v-bind:staffId="parseInt($route.params.id)" />
      <teacher-classes v-bind:staffId="parseInt($route.params.id)" />
    </div>
  </body>
</template>

<script>
import StaffDetail from "../components/StaffDetail.vue";
import TeacherClasses from "../components/TeacherClasses.vue";

export default {
  components: { TeacherClasses, StaffDetail },
};
</script>,
    CreateClass

<style scoped>
body {
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
}
</style>