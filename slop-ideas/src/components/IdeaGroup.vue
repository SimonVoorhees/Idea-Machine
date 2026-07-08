<script setup lang="ts">
import IdeaItem from './IdeaItem.vue'
import { ref, reactive, onMounted, onUnmounted, toRef, useTemplateRef } from 'vue'
import domtoimage from 'dom-to-image'
import FileSaver from 'file-saver'
import { getRandomArbitrary } from '../utilities.js'
const props = defineProps(['group'])
const ideas = toRef(() => {
  let newObj = []
  for (let i = 0; i < props.group.ideas.length; i++) {
    newObj[i] = {
      idea: props.group.ideas[i],
      dragX: Math.random() * 200,
      dragY: Math.random() * 200,
    }
  }
  return reactive(newObj)
});
const randomSkew = getRandomArbitrary(-1,1);

const styleObject = {
  transform: `skew(${randomSkew}deg, ${randomSkew}deg)`
}
const IdeaGroupTemplateRef = useTemplateRef('IdeaGroup')
const onClickDownload = (e:Event) => {
  console.log(IdeaGroupTemplateRef.value)
  domtoimage.toBlob(IdeaGroupTemplateRef.value).then(function (blob) {
    FileSaver.saveAs(blob, 'my-node.png')
  })
}

// const isDragging = ref(false)
// const mouseX = ref(0)
// const mouseY = ref(0)

// const dragStartX = ref(0)
// const dragStartY = ref(0)

// const startDrag = (event) => {
//   isDragging.value = true
//   if (event?.target?.id !== undefined) {
//     dragStartX.value = event.clientX - ideas.value[Number(event.target.id)].dragX
//     dragStartY.value = event.clientY - ideas.value[Number(event.target.id)].dragY
//   } else if (event?.target?.parentElement?.id !== undefined) {
//     dragStartX.value = event.clientX - ideas.value[Number(event.target.parentElement.id)].dragX
//     dragStartY.value = event.clientY - ideas.value[Number(event.target.parentElement.id)].dragY
//   }
//   console.log(ideas.value[Number(event.target?.parentElement?.id)])
// }
// const handleDragMove = (event) => {
//   if (isDragging.value) {
//     if (event?.target?.id !== undefined) {
//       ideas.value[Number(event.target.id)].dragX = event.clientX - dragStartX.value
//       ideas.value[Number(event.target.id)].dragY = event.clientY - dragStartY.value
//     } else if (event?.target?.parentElement?.id !== undefined) {
//       ideas.value[Number(event.target.parentElement.id)].dragX = event.clientX - dragStartX.value
//       ideas.value[Number(event.target.parentElement.id)].dragY = event.clientY - dragStartY.value
//     }
//   }
// }

// const stopDrag = () => {
//   isDragging.value = false
// }
// onMounted(() => {
//   window.addEventListener('mousemove', handleDragMove)
//   window.addEventListener('mouseup', stopDrag)
// })

// onUnmounted(() => {
//   window.removeEventListener('mousemove', handleDragMove)
//   window.removeEventListener('mouseup', stopDrag)
// })
</script>

<template>
  <!-- 
 -->
  <section class="IdeaGroup-Wrapper" ref="IdeaGroup">
    <ul class="IdeaGroup" :style="styleObject">
      <IdeaItem v-for="(object, index) in ideas" :id="index" :idea="object.idea" />
      <!--
      @mousedown.left="startDrag"
      class="draggable" :style="{
        left: object.dragX + 'px',
        top: object.dragY + 'px',
      }" -->
    </ul>
  </section>
  <button class="IdeaGroup-Download" @click="onClickDownload">&#8623;</button>
</template>

<style>
.draggable {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: move;
  user-select: none;
}

.IdeaGroup {
  position: static;
  width: fit-content;
  background-color: var(--orange);
  color: var(--blue);
  border: 8px solid var(--blue);
  border-top: 8px solid var(--red);
  border-left: 8px solid var(--red);
  list-style: none;
  padding: 82px 82px 82px 36px;
  margin: auto;
  font-size: 48px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  flex-wrap: wrap;
  gap: 12px;
  font-family: yokelvision-font;
}
.IdeaGroup:last-of-type {
  margin-bottom: 8px;
}
.IdeaGroup:first-of-type {
  margin-top: 32px;
}
.IdeaGroup-Wrapper{
  padding: 8px;
}
.IdeaGroup-Download {
  margin: 0px 16px 256px 0px;
  background-color: var(--orange);
  color: var(--cyan);
  border: none;
  font-size: 32px;
  font-weight: 900;
  padding-bottom: 0px;
  align-self: flex-end;
  background-color: var(--blue);
  border-radius: 128px 256px;
  transform: skew(-25deg, 25deg);
}
.IdeaGroup-Download:hover {
  color: var(--orange);
}
.IdeaGroup-Download:active {
  background-color: var(--cyan);
  color: var(--red);
}
</style>
