\score {
\transpose f g {
<<
\new Staff \with {midiInstrument = #"lead 6 (voices)"} {
\time 4/4
\clef treble
\key f \major

r2 r8 d''8\noBeam~ d''8 d''8
d''4~ d''8 bes'8~ bes'8[ a'8]~\noBeam a'8 g'8~
g'4 r4 r4 r8 f'8
f'4~ f'8 f'8~ f'4 r4
}
\addlyrics {
No re -- treat ba by no su -- rre -- nder
}

\new Staff \with {midiInstrument = #"electric guitar (clean)"} {
\time 4/4
\clef treble
\key f \major

r2 <c' f' a' c''>8 <c'~ f'~ a'~ c''~>8 <c' f' a' c''>8 <c' f' a' c''>8
<bes f' bes' d''>4 <bes f' bes' d''>8  <bes~ f'~ bes'~ d''~>8 <bes f' bes' d''>8 <bes~ f'~ bes'~ d''~>8 <bes f' bes' d''>8 <bes f' bes' d''>8
<c' e' g' c''>4  <c' e' g' c''>8 <c'~ e'~ g'~ c''~>8  <c' e' g' c''>8 <c'~ e'~ g'~ c''~>8 <c' e' g' c''>8 <c' e' g' c''>8
<c' f' a' c''>4  <c' f' a' c''>8 <c'~ f'~ a'~ c''~>8  <c' f' a' c''>8 <c'~ f'~ a'~ c''~>8 <c' f' a' c''>8 <c' f' a' c''>8
}

\new Staff \with {midiInstrument = #"electric bass (finger)"} {
\time 4/4
\clef bass
\key f \major

r2 f,8 f,8 f,8 f,8
f,8 f,8 f,8 f,8 f,8 f,8 f,8 a,8
c8 c8 c8 c8 c8 c8 d8 e8
f8 f8 f8 a8 bes8 a8 g8 f8 

}
\new GrandStaff \with {midiInstrument = #"rock organ"} 
<<
\new Staff {
\time 4/4
\clef treble
\key f \major
<<
{ s1 s1 s1 a''2 a''8 d'''8~ d'''4 }
\\
{ 
<f' a' f'' a''>1
<d' bes' f''>1
<e' g' e'' g''>1
<f' a' f''>1  
}
>>
}
\new Staff {
\time 4/4
\clef bass
\key f \major
<f c'>1
<bes, f bes>1
<c c'>1
<f c'>1
}
>>
>>
}
\layout {}


\midi {
\tempo 4 = 144
}
}
