<template>
  <div class="kudo-types">
    <table class="kudo-list">
      <p>Available Kudo Types</p>
      <tr>
        <th>Kudo Type ID:</th>
        <th>Kudo Name:</th>
        <th>Description:</th>
        <th>Value:</th>
      </tr>
      <tr
        v-for="type in this.$store.state.kudoTypes"
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
  data() {},
  methods: {
    getKudoTypes() {
      kudoService.getKudoTypes().then((response) => {
        this.$store.commit("SET_KUDO_TYPES", response.data);
      });
    },
  },
  created() {
    this.getKudoTypes();
  },
};
</script>

<style>
.kudo-list {
  border: 1px solid black;
  display: block;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: bold;
  background-color: rgba(255, 255, 255, 0.657);
}
th {
  padding-right: 100px;
  border: 1px solid black;
}
td {
  padding: 10px;
  border: 1px solid black;
  text-align: center;
}
</style>