<template>
  <body>
    <div>
      <table class="student-list">
        <th colspan="3" class="title">Search For Students</th>

        <tr>
          <th class="header-table">First Name:</th>
          <th class="header-table">Last Name:</th>
          <th class="header-table">Class of:</th>
        </tr>
        <tr>
          <td class="firstName">
            <input id="firstName" type="text" v-model="filter.firstName" />
          </td>
          <td>
            <input id="lastName" type="text" v-model="filter.lastName" />
          </td>
          <td>
            <input type="number" id="classOf" v-model="filter.graduationYear" />
          </td>
        </tr>
        <tr
          v-on:click="loadStudentDetail(student.id)"
          v-for="student in filteredList"
          v-bind:key="student.id"
          v-bind:value="student.id"
          class="col-centered"
        >
          <td class="col-centered" id="link-indicate">
            {{ student.firstName }}
          </td>
          <td class="col-centered">{{ student.lastName }}</td>
          <td class="col-centered">{{ student.graduationYear }}</td>
        </tr>
      </table>
    </div>
  </body>
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
        filteredStudents = filteredStudents.filter((student) =>
          student.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredStudents = filteredStudents.filter((student) =>
          student.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.graduationYear != "") {
        filteredStudents = filteredStudents.filter((student) =>
          student.graduationYear
            .toString()
            .includes(this.filter.graduationYear.toString())
        );
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
    loadStudentDetail(id) {
      this.$router.push({ name: "StudentProfile", params: { id: id } });
    },
  },
  created() {
    this.getStudentProfiles();
  },
};
</script>
<style scoped>
body {
  background-color: white;
}
.student-list {
  background-color: white;
  font-family: Arial, Helvetica, sans-serif;
  border: black solid 1px;
  border-radius: 5px;
  padding: 15px;
}
.header-table {
  vertical-align: right;
  color: darkorange;
}
.title {
  font-size: x-large;
  padding: none;
}

p {
  color: black;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: bold;
  display: block;
}
.col-centered {
  margin: 0 auto;
  float: none;
}
body {
  padding: 10px;
  margin-left: 500px;
  margin-right: 500px;
  color: black;
  border: black 5px;
}
.col-centered:hover {
  color: darkorange;
  font-weight: bold;
}
#link-indicate {
  text-decoration: underline;
}
</style>
