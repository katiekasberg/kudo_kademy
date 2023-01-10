<template>
  <body>
    <student-list />
  </body>
</template>
<script>
import StudentList from "../components/StudentList.vue";

export default {
  components: { StudentList },
};
</script>
<style scoped>
body {
  min-height: 500px;
  background-color: rgba(255, 255, 255, 0.25);
  padding-bottom: 200px;
}
</style>