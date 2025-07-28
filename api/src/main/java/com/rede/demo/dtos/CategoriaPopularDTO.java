package com.rede.demo.dtos;

import com.rede.demo.domain.Flags.Categoria;

public record CategoriaPopularDTO(
        Categoria Categoria,
        Long TotalUsuarios

) {
}