<template>
  <div class="student-profile">
    <h1>Student Profile</h1>
    <div id="profileInfo">
      <p id="first-name">First Name: {{ this.$store.state.activeStudentProfile.firstName }}</p>
      <p id="last-name">Last Name: {{ this.$store.state.activeStudentProfile.lastName }}</p>
      <p id="school">School: {{ this.$store.state.activeStudentProfile.schoolId }}</p>
      <p id="graduation-year">Class Of: {{ this.$store.state.activeStudentProfile.graduationYear }}</p>
      <p id="email">Email Address: {{ this.$store.state.activeStudentProfile.email }}</p>
    </div>
    <div id="profileImage">
      <img v-bind:src="this.$store.state.activeStudentProfile.image" />
    </div>
  </div>
</template>

<script>
import StudentService from "../services/StudentService";

export default {
  name: "StudentDetails",
  props: {
    studentId: Number,
  },
  data() {
    return {};
  },
  methods: {},
  created() {
    StudentService.getStudentProfileById(this.studentId)
      .then((response) => {
        this.$store.commit("SET_ACTIVE_STUDENT_PROFILE", response.data);
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });
  },
};
</script>

<style>
.student-profile {
  display: grid;
  justify-content: center;
}

img {
  display: grid;
  width: 50%;
  justify-items: center;
  justify-content: center;
}
</style>