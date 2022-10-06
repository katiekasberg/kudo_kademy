<template>
  <div>
    <p>Children assigned to this account:</p>
    <table>
      <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Image</th>
      </tr>
      <tr
        v-for="child in this.students"
        v-bind:key="child.id"
        v-bind:value="child.id"
      >
        <td>
          <router-link
            v-bind:to="{ name: 'StudentProfile', params: { id: child.id } }"
          >
            {{ child.firstName }} {{ child.lastName }}
          </router-link>
        </td>
        <td>
          {{ child.email }}
        </td>
        <td>
          <img v-bind:src="child.image" height="100" width="100" />
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
import ParentService from "../services/ParentService";

export default {
  name: "ListChildren",
  props: {
    parentId: Number,
  },
  data() {
    return {
      students: [],
    };
  },
  methods: {
    getChildren() {
      ParentService.getStudentsByParentId(this.parentId).then((response) => {
        this.students = response.data;
      });
    },
  },
  created() {
    this.getChildren();
  },
  updated() {
    this.getChildren();
  },
};
</script>

<style scoped>
.kudo-list {
  border: 1px solid black;
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
  padding-left: 150px;
  padding-right: 150px;
}
td {
  padding: 10px;
  border-radius: 5px;
  border: 1px solid black;
  text-align: center;
  background-color: white;
}
</style>