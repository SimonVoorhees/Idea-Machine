<script setup lang="ts">
import { ref } from 'vue'
import axios from 'axios'
import IdeaGroup from './IdeaGroup.vue'

interface submitTarget extends EventTarget{
  groups: {value:number}
  amountPerGroup: {value:number}
}
const ideas = ref([])
const getNumber = async (amount:number) => {
  try {
    const response = await axios.get(`http://127.0.0.1:8080/${amount}`)
    ideas.value = response.data
  } catch (error) {
    console.log(error)
  }
}
const getGroups = async (groups:number, amountPerGroup:number) => {
  try {
    const response = await axios.get(`http://127.0.0.1:8080/${groups}/${amountPerGroup}`)
    ideas.value = response.data
  } catch (error) {
    console.log(error)
  }
}
const onSubmit = (e:Event) => {
  const submitTarget = e.target as submitTarget;
  getGroups(submitTarget.groups.value, submitTarget.amountPerGroup.value)
}
</script>

<template>
  <form @submit.prevent="onSubmit" class="IdeaForm">
    <section class="IdeaForm-Section">
      <label class="IdeaForm-Label">Groups</label>
      <input type="text" name="groups" class="IdeaForm-Input" required />
    </section>
    <section class="IdeaForm-Section">
      <label class="IdeaForm-Label">Ideas</label>
      <input
        type="text"
        name="amountPerGroup"
        class="IdeaForm-Input"
        label="Amount Per Group"
        required
      />
    </section>
    <button type="submit" class="IdeaForm-Button">Ready!</button>
  </form>
  <section class="IdeaGroups-Container">
    <IdeaGroup v-for="group in ideas" :group="group" />
  </section>
</template>

<style>
.IdeaForm {
  background-color: var(--orange);
  padding: 16px 10%;
  font-family: yokelvision-font;
  font-size: 32px;
  display: flex;
  flex-direction: row;
  width: 100%;
  align-items: flex-end;
  justify-content: flex-end;
}
.IdeaForm-Section {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-right: 32px;
  @media only screen and (min-width: 1024px) {
    align-items: flex-end;
    width: 100%;
  }
}
.IdeaForm-Label {
  color: var(--blue);
  font-size: 48px;
  text-align: right;
  text-wrap: nowrap;
}
.IdeaForm-Input {
  margin-right: 12px;
  background-color: var(--blue);
  color: var(--orange);
  font-size: 32px;
  padding: 16px 16px 16px 32px;
  border: none;
  width: 85px;
  border-radius: 128px 256px;
}
.IdeaForm-Button {
  background-color: var(--orange);
  color: var(--blue);
  border: none;
  font-size: 64px;
  font-weight: 900;
  height: 100%;
  padding-bottom: 0px;
  margin-bottom: -24px;
  width: 100%;
  z-index: 3;
  font-family: yokelvision-font;
  margin-left: 32px;
}
.IdeaForm-Button:hover {
  color: var(--orange);
  background-color: var(--blue);
  border-radius: 128px 256px;
  font-family: laff-riot-nf-font;
}
.IdeaForm-Button:active {
  background-color: var(--orange) !important;
  color: var(--blue) !important;
  border-radius: 128px 256px;
  font-family: laff-riot-nf-font;
}
.IdeaGroups-Container {
  background-color: var(--orange);
  color: var(--blue);
  margin: 0;
  padding: 8px;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
