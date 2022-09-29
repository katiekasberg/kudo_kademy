<template>
  <div>
    <table class="student-list">
      <p>Search by Student</p>
      <tr>
        <th>First Name:</th>
        <th>Last Name:</th>
        <th>Class of:</th>
      </tr>
      <tr>
        <td>
          <input id="firstName" type="text" v-model="filter.firstName" />
        </td>
        <td>
          <input id="lastName" type="text" v-model="filter.lastName" />
        </td>
        <td>
          <input id="classOf" type="text" v-model="filter.graduationYear" />
        </td>
      </tr>
      <tr
        v-for="student in filteredList"
        v-bind:key="student.id"
        v-bind:value="student.id"
      >
        <td>{{ student.firstName }}</td>
        <td>{{ student.lastName }}</td>
        <td>{{ student.graduationYear }}</td>
      </tr>
    </table>
  </div>
</template>
<script>
import studentService from "../services/StudentService";

export default {
  data() {
    return {
      filter: {
        firstName: "",
        lastName: "",
        graduationYear: "",
      },
    };
  },
  computed: {
    filteredList() {
      let filteredStudents = this.$store.state.studentProfiles;
      if (this.filter.firstName != "") {
        filteredStudents = filteredStudents.filter((student) => {
          student.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase);
        });
      }
      return filteredStudents;
    },
  },
  methods: {
    getStudentProfiles() {
      studentService.getStudentProfiles().then((response) => {
        this.$store.commit("SET_STUDENT_PROFILES", response.data);
      });
    },
  },
  created() {
    this.getStudentProfiles();
  },
};
</script>
<style scoped>
.student-list {
  display: grid;
  align-items: center;
  justify-content: center;
}
th {
  padding-right: 100px;
}
</style>