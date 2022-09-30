<template>
  <div class="student-kudos">
    <table class="list-kudos">
      <tr>
        <th>Kudo Type ID</th>
        <th>Kudo Name</th>
        <th>Description</th>
        <th>Value</th>
      </tr>
      <tr
        v-for="type in this.$store.state.studentKudos"
        v-bind:key="type.id"
        v-bind:value="type.id"
      >
        <td>{{ type.id }}</td>
        <td>{{ type.name }}</td>
        <td>{{ type.description }}</td>
        <td>{{ type.value }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import kudoService from "../services/KudosService";
export default {
  data() {
  },
  methods: {
    getKudosByStudentId(studentId) {
      kudoService
        .getKudosByStudentId(studentId)
        .then((response) => {
          this.studentKudos = response.data;
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