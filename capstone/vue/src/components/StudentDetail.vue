<template>
  <div class="container">
    <div id="profile-image">
      <img v-bind:src="this.$store.state.activeStudentProfile.image" />
      <!-- <img src="../../resources/profile-icon.png" alt="" /> -->
    </div>
    <div class="student-profile">
      <h1>Student Profile</h1>
      <div id="profileInfo">
        <p id="first-name">
          First Name: {{ this.$store.state.activeStudentProfile.firstName }}
        </p>
        <p id="last-name">
          Last Name: {{ this.$store.state.activeStudentProfile.lastName }}
        </p>
        <p id="school">
          School: {{ this.$store.state.activeStudentProfile.schoolId }}
        </p>
        <p id="graduation-year">
          Class Of: {{ this.$store.state.activeStudentProfile.graduationYear }}
        </p>
        <p id="email">
          Email Address: {{ this.$store.state.activeStudentProfile.email }}
        </p>
      </div>
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
.container {
  display: flex;
  flex-direction: row;
  background-color: rgba(255, 255, 255, 0.657);
  padding-right: 136px;
  font-family: Arial, Helvetica, sans-serif;
}
img {
  align-content: flex-start;
  border-radius: 50%;
  justify-content: right;
  align-items: right;
  margin-left: 50px;
  height: 200px;
  width: 200px;
  image-rendering: auto;
}
</style>