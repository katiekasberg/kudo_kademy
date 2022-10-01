<template>
  <div>
    <table class="kudo-list">
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
.kudo-style {
  display: grid;
  align-items: center;
  justify-content: center;
  background-color: white;
  font-family: Arial, Helvetica, sans-serif;
  border-block: black 5px;
}
th {
  padding-right: 100px;
}
</style>