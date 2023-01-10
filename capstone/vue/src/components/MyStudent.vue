<template>
  <body class="container">
    <div>
      <table class="my-student">
        <p>My Students</p>
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
            <input type="number" id="classOf" v-model="filter.graduationYear" />
          </td>
        </tr>
        <tr
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
    myStudentFilteredList() {
      let myStudents = this.$store.state.studentProfiles;

      if (this.filter.parent_id === myStudents.parent_id) {
        myStudents = myStudents.filter((student) => student.parent);
        return myStudents;
      } else {
        return "No Students Associated with this Parent";
      }
    },
  },
  methods: {
    getStudentProfilesByParentId(parent_id, user_id) {
      if (user_id == parent_id) {
        studentService.getStudentProfiles().then((response) => {
          this.$store.commit("SET_STUDENT_PROFILES", response.data);
        });
      }
    },

    created() {
      this.getStudentProfilesByParentId();
    },
  },
};
</script>
<style scoped>
.container {
  display: grid;
  align-content: center;
  justify-content: center;
  grid-row-gap: 20px;
  align-content: center;
  justify-content: center;
  margin: auto;
}

h1 {
  display: grid;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  color: darkorange;
  letter-spacing: 2px;
}
</style>