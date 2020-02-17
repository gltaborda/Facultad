#ifndef NUCLEO_PRINCIPAL_H_INCLUDED
#define NUCLEO_PRINCIPAL_H_INCLUDED

class NucleoPrincipal
{
    private:
        Lista<NodoCentral*> *listaCentrales;
    public:
        NucleoPrincipal();
        ~NucleoPrincipal();

};

NucleoPrincipal::NucleoPrincipal(){
    this->listaCentrales = new Lista<NodoCentral*>;
}
NucleoPrincipal::~NucleoPrincipal(){
    this->listaCentrales->~Lista();
}


#endif // NUCLEO_PRINCIPAL_H_INCLUDED
