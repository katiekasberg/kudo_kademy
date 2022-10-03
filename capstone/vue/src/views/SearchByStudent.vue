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
  background: linear-gradient(
    360deg,
    white,
    rgb(241, 197, 99),
    rgb(253, 223, 158),
    white
  );
  min-height: auto;
}
</style>