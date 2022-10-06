<template>
  <div>
    <table>
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
</style>