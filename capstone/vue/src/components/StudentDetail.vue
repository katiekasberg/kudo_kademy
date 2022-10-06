<template>
  <div>
    <h1>Student Profile</h1>
    <div class="layout">
      <div class="info">
        <p id="first-name">
          First Name: {{ this.$store.state.activeStudentProfile.firstName }}
        </p>
        <p id="last-name">
          Last Name: {{ this.$store.state.activeStudentProfile.lastName }}
        </p>
        <p id="school">School: Cypress Hill</p>
        <!-- <p id="school">
          School: {{ this.$store.state.activeStudentProfile.schoolId }}
        </p> -->
        <p id="graduation-year">
          Class Of
          {{ this.$store.state.activeStudentProfile.graduationYear }}
        </p>
        <p id="email">
          Email: {{ this.$store.state.activeStudentProfile.email }}
        </p>
      </div>
      <img v-bind:src="this.$store.state.activeStudentProfile.image" />
      <!-- <img src="../../resources/profile-icon.png" alt="" /> -->
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

<style scoped>
.layout {
  display: flex;
  flex-direction: row;
  padding-bottom: 100px;
}
.info {
  display: flex;
  flex-direction: column;
  height: 150px;
  margin: 20px;
}

img {
  border-radius: 50%;
  justify-content: right;
  align-items: right;
  height: 200px;
  width: 200px;
  image-rendering: auto;
  padding-top: 50px;
}
</style>