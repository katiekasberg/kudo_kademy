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
  min-height: auto;
}
</style>