<template>
  <div class="container">
    <add-student-to-class />
  </div>
</template>
 
<script>
import AddStudentToClass from "../components/AddStudentToClass.vue";
 
export default {
  components: { AddStudentToClass },
};
</script>
 
<style scoped>
.container {
  display: grid;
  align-content: center;
  margin-left: 300px;
  grid-template-columns: 1fr 3fr;
  width: 75%;
  justify-content: flex-start;
}
</style>