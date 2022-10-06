<template>
  <body>
    <div class="container">
      <student-detail v-bind:studentId="parseInt($route.params.id)" /><br />
    </div>
    <div class="components">
      <student-classes v-bind:studentId="parseInt($route.params.id)" /><br />
      <student-kudos v-bind:studentId="parseInt($route.params.id)" />
    </div>
  </body>
</template>

<script>
import StudentClasses from "../components/StudentClasses.vue";
import StudentDetail from "../components/StudentDetail.vue";
import StudentKudos from "../components/StudentKudos.vue";

export default {
  name: "StudentProfile",
  components: { StudentDetail, StudentKudos, StudentClasses },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-content: center;
  margin-left: 200px;
  grid-template-columns: 1fr 3fr;
  width: 75%;
  justify-content: flex-start;
  padding-bottom: 100px;
}
.components {
  display: grid;
  align-content: center;
  justify-content: center;
}
</style>