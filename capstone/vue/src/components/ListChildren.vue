<template>
  <div>
    <p>Children Assigned to this account:</p>
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
          <img v-bind:src='child.image' height=100 width=100 />
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
};
</script>

<style>
</style>