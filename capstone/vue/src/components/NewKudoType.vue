<template>
  <div class="newKudoTypes">
    <form v-on:submit.prevent action="submit" class="newKudoForm">
      <label for="KudoName"
        >Name:
        <input id="KudoName" type="text" v-model="newKudoType.name" />
      </label>
      <label for="description"
        >Description:
        <input
          id="KudoDescription"
          type="text"
          v-model="newKudoType.description"
        />
      </label>
      <label for="value">Value:</label>
      <input id="value" type="number" v-model="newKudoType.value" />
      <button type="submit" v-on:click="saveKudoType()">Submit</button>
    </form>
  </div>
</template>

<script>
import kudoService from "../services/KudosService";

export default {
  data() {
    return {
      newKudoType: {
        name: "",
        description: "",
        value: "",
      },
    };
  },
  methods: {
    saveKudoType() {
      kudoService.addKudoType(this.newKudoType).then((response) => {
        if (response.status === 201) {
          this.newKudoType.name = "";
          this.newKudoType.description = "";
          this.newKudoType.value = "";
        }
      });
      //     kudoService.getKudoTypes().then((response) =>{
      //     this.$store.commit("SET_KUDO_TYPES", response.data);
      //   })
    },
  },
};
</script>

<style>
.newKudoTypes {
  justify-content: center;
  text-align: center;
}
.newKudoForm {
  display: inline-block;
  position: absolute;
}
</style>