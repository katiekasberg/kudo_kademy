<template>
  <body>
    <div>
      <table class="student-list">

        <th colspan="3">Search by Student</th>

        <tr class="header-table">
          <th>First Name:</th>
          <th>Last Name:</th>
          <th>Class of:</th>
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
          <td class="col-centered">{{ student.firstName }}</td>
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
        filteredStudents = filteredStudents.filter(
          (student) => student.graduationYear == this.filter.graduationYear
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
    loadStudentDetail(id){
      this.$router.push({name:'StudentProfile', params:{id:id}})
    }
  },
  created() {
    this.getStudentProfiles();
  },
};
</script>
<style scoped>
.student-list {
  /* display: grid;
  align-items: center;
  justify-content: center; */
  background-color: white;
  font-family: Arial, Helvetica, sans-serif;
  border: black solid 5px;
  
}
.header-table{
  text-align: center;
}
th {
  padding-right: 100px;
  text-align: center;
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
  /* padding-right: 115px; */
}
body {
  padding: 10px;
  margin-left: 500px;
  margin-right: 500px;
  color: black;
  border: black 5px;
}
.col-centered:hover{
  color: blue;
  font-weight: bold;
}
</style>
