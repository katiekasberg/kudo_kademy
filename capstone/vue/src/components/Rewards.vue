<template>
  <div class="kudo-types">
    <table class="kudo-list">
      <p>Available Kudos</p>
      <tr>
        <!-- <th>Kudo Type ID:</th> -->
        <th>Kudos Category:</th>
        <th>Description:</th>
        <th>Points:</th>
      </tr>
      <tr
        v-for="type in this.$store.state.kudoTypes"
        v-bind:key="type.id"
        v-bind:value="type.id"
      >
        <!-- <td>{{ type.id }}</td> -->
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
  updated() {
    this.getKudoTypes();
  },
};
</script>

<style scoped>
.kudo-list {
  font-size: large;
  border-radius: 5px;
  display: block;
  align-items: center;
  justify-content: center;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: bold;
  background-color: rgba(255, 255, 255, 0.25);
  padding-left: 100px;
  padding-right: 100px;
  padding-bottom: 100px;
  font-size: medium;
  font-weight: normal;
}
p {
  text-align: center;
}
th {
  border: 1px solid black;
  border-radius: 5px;
  background-color: white;
  text-align: center;
  padding-left: 50px;
  padding-right: 50px;
}
td {
  padding: 10px;
  border-radius: 5px;
  border: 1px solid black;
  text-align: center;
  background-color: white;
}
</style>