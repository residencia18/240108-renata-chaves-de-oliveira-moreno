import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'highlight'
})
export class HighlightPipe implements PipeTransform {
  transform(text: string, term: string): string {
    if (!term || !text) {
      return text;
    }

    const regex = new RegExp(term, 'gi');
    return text.replace(regex, match => `<strong>${match}</strong>`);
  }
}
