<template>
  <div class="background">
    <form v-on:submit.prevent>
      <div>
        <label for="name">name</label>
        <input type="text" v-model="name" />
        <label for="description">description</label>
        <input type="text" v-model="description" />
        <label for="value">value</label>
        <input type="number" v-model="value" />
      </div>
      <div>
        <button type="submit" v-on:click="updateKudoType()">
          Save Kudo Type
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import KudosService from "../services/KudosService";

export default {
  name: "update-kudo-type",
  props: {
    kudoTypeId: Number,
  },
  data() {
    return {
      name: "",
      description: "",
      value: 0,
    };
  },
  methods: {
    updateKudoType() {
      const kudoType = {
        id: this.kudoTypeId,
        name: this.name,
        description: this.description,
        value: this.value,
      };

      KudosService.updateKudoType(kudoType.id, kudoType).then((response) => {
        if (response.status === 200) {
          this.$router.push("/");
        }
      });
    },
  },
  created() {
    KudosService.getKudoTypeById(this.kudoTypeId)
      .then((response) => {
        this.$store.commit("SET_ACTIVE_KUDO_TYPE", response.data);
        this.name = response.data.name;
        this.description = response.data.description;
        this.value = response.data.value;
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });
  },
};
</script>

<style scoped>
.background {
  background-color: rgba(255, 255, 255, 0.25);
  border-radius: 5px;
  border-width: 1px;
}
input {
  background-color: white;
  border-radius: 5px;
}
</style>