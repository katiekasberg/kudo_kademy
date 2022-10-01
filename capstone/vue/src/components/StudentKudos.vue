<template>
  <div class="student-kudos">
    <p id="student-points">Current Student Points: {{this.totalPoints}} </p>
    <table class="list-kudos">
      <tr>
        <th>Kudo ID</th>
        <th>From: </th>
        <th>Message: </th>
        <th>Kudo Type: </th>
      </tr>
      <tr
        v-for="kudo in this.$store.state.studentKudos"
        v-bind:key="kudo.id"
        v-bind:value="kudo.id"
      >
        <td>{{ kudo.id }}</td>
        <td>{{kudo.first_name}}</td>
        
        <td>{{ kudo.message }}</td>
        <td>{{ kudo.typeId }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import kudoService from "../services/KudosService";
import PointService from '../services/PointService';
export default {
  name: "StudentKudos",
  props: {
    studentId: Number
  },
  data() {
    return {
      totalPoints: 0,
      kudoType: Object,
      teacherProfile: Object,
    };
  },
  methods: {
    getKudosByStudentId() {
      kudoService
        .getKudosByStudentId(this.studentId)
        .then((response) => {
          this.$store.commit("SET_STUDENT_KUDOS", response.data);
        });
    },

    getCurrentScore() {
      PointService.getPointsByStudentId(this.studentId)
      .then((response) => {
        this.totalPoints = response.data;
      });
    },
  },
  created() {
    this.getKudosByStudentId();
    this.getCurrentScore();
  },
};
</script>

<style>
</style>