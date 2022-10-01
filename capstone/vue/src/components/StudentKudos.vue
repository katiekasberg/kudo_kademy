<template>
  <div class="student-kudos">
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
        <td>{{ kudo.teacherId }}</td>
        <td>{{ kudo.message }}</td>
        <td>{{ kudo.typeId }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import kudoService from "../services/KudosService";
export default {
  name: "StudentKudos",
  props: {
    studentId: Number
  },
  data() {
  },
  methods: {
    getKudosByStudentId() {
      kudoService
        .getKudosByStudentId(this.studentId)
        .then((response) => {
          this.$store.commit("SET_STUDENT_KUDOS", response.data);
        });
    },
  },
  created() {
    this.getKudosByStudentId();
  },
};
</script>

<style>
</style>