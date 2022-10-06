<template>
  <div>
    <table>
      <p>Most Recent Kudos in Your Grade</p>
      <tr>
        <th>Student</th>
        <th>Type</th>
        <th>Description</th>
        <th>Points</th>
      </tr>
      <tr
        v-for="kudo in this.GradeLevelKudos"
        v-bind:key="kudo.id"
        v-bind:value="kudo.id"
      >
        <td>{{ kudo.firstName }} {{ kudo.lastName }}</td>
        <td>{{ kudo.kudoTypeName }}</td>
        <td>{{ kudo.kudoTypeDescription }}</td>
        <td>{{ kudo.kudoTypeValue }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import KudosService from "../services/KudosService";
import StudentService from "../services/StudentService";
export default {
  data() {
    return {
      GradeLevelKudos: [],
      graduationYear: 0,
    };
  },

  methods: {
    getGraduationYear() {
      StudentService.getStudentProfileById(this.$store.state.user.id).then(
        (response) => {
          this.graduationYear = response.data.graduationYear;
          this.getKudosByGradYear();
        }
      );
    },

    getKudosByGradYear() {
      KudosService.getKudosByGradYear(this.graduationYear).then((response) => {
        this.GradeLevelKudos = response.data;
      });
    },
  },
  created() {
    this.getGraduationYear();
  },
};
</script>
<style scoped>
.container {
  font-size: large;
  border-radius: 5px;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  background-color: rgba(255, 255, 255, 0.25);
  font-size: medium;
  font-weight: normal;
}

th,
td {
  padding: 10px;
  border-radius: 5px;
  border: 2px solid black;
  text-align: left;
  background-color: white;
  width: 250px;
  height: 30px;
  table-layout: fixed;
}

p {
  text-align: center;
  font-weight: bold;
  font-size: large;
  border-radius: 5px;

  border-color: black;
}
table {
  display: grid;
  align-content: center;
}
</style>
